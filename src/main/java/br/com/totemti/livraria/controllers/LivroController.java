package br.com.totemti.livraria.controllers;

import br.com.totemti.livraria.dto.AutorDTO;
import br.com.totemti.livraria.dto.LivroDTO;
import br.com.totemti.livraria.models.Editora;
import br.com.totemti.livraria.models.Livro;
import br.com.totemti.livraria.services.AutorService;
import br.com.totemti.livraria.services.EditoraService;
import br.com.totemti.livraria.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {


    private ModelMapper modelMapper;
    private LivroService livroService;
    private AutorService autorService;
    private EditoraService editoraService;

    @Autowired
    public LivroController(ModelMapper modelMapper, LivroService livroService, AutorService autorService, EditoraService editoraService) {
        this.modelMapper = modelMapper;
        this.livroService = livroService;
        this.autorService = autorService;
        this.editoraService = editoraService;
    }

    @GetMapping
    public ResponseEntity<Page<LivroDTO>> index(@PageableDefault(sort = "nome") Pageable pageable) {
        Page livros = livroService
                .listar(pageable)
                .map(livro -> modelMapper.map(livro, LivroDTO.class));

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> show(@PathVariable Long id) {

        Livro livro = livroService.buscar(id);

        LivroDTO livroDTO = modelMapper.map(livro, LivroDTO.class);
        return ResponseEntity.ok(livroDTO);

    }

    @Transactional    // spring gerenciar caso tenha algum erro no fluxo. EX: se teve algum alter ou inclusao , ele faz um rollback
    @PostMapping
    public ResponseEntity<LivroDTO> store(@RequestBody LivroDTO livroDTO){
        Livro livro = modelMapper.map(livroDTO, Livro.class);
        atribuirEditora(livro,livroDTO);
        atribuirAutores(livro,livroDTO);

        LivroDTO novoLivro = modelMapper.map(livroService.salvar(livro),LivroDTO.class);

        return ResponseEntity.ok(novoLivro);
    }

    private void atribuirAutores(Livro livro, LivroDTO livroDTO) {
        if(livroDTO.getAutores() != null && !livroDTO.getAutores().isEmpty()){  // verificar se o user enviou autor
            for(AutorDTO autorDTO: livroDTO.getAutores()){
                livro.incluirAutor(autorService.buscar(autorDTO.getId()));
            }
        }
    }

    private void atribuirEditora(Livro livro, LivroDTO livroDTO) {
        Editora editora = editoraService.buscar(livroDTO.getEditora().getId()); // pegar id da editora
        livro.setEditora(editora);
    }
}
