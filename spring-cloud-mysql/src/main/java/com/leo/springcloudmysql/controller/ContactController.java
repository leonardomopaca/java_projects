package com.leo.springcloudmysql.controller;

import com.leo.springcloudmysql.model.Contact;
import com.leo.springcloudmysql.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* O Controller é a classe responsável por expor cada URI que estará disponível na API
* */
@RestController
@RequestMapping ({"/contacts"})
public class ContactController {

    private ContactRepository repository;

    ContactController(ContactRepository contactRepository){
        this.repository = contactRepository;
    }

    //métodos do CRUD aqui
    /*
    * Lista todos os contatos - O método findAll da interface JpaRepository faz um
    * select * from contacts
    * Como esta é uma API RESTful, pode-se omitir o código
    * @RequestMapping(value="/contacts", method=RequestMethod.GET
    * utilizando apenas a anotação @GetMapping
    * Resultado JSON*/
    public List findAll(){
        return repository.findAll();
    }

    /*
    * Buscando Contato pelo ID
    * Seguindo os conceitos RESTful, é necessário passar na URL o ID do registro.
    * A anotação @PathVariable vincula o parâmetro passado pelo método com a variável do path.
    * Note que o parâmetro long id tem o mesmo nome do path declarado em @GetMapping(path = {"/{id}"}).
    * A lógica para obter um contato específico é utilizar o método findById da interface JpaRepository
    * (que irá fazer um select * from contacts where id = ?). Caso o registro seja encontrado,
    * é retornado o status HTTP 200 (ResponseEntity.ok()) e no corpo da resposta é enviado o registro.
    * Caso o registro não seja encontrado é retornado o status HTTP 404 - Não Encontrado (ResponseEntity.notFound()).
    *
    * Um ponto importante é notar a diferença entre os métodos findAll e findById da interface JpaRepository.
    * O método findAll retorna uma lista de entidades. Caso não exista nenhum registro na tabela, é retornada uma lista vazia ([]).
    * Já o método findById retorna um Optional<T>. O classe Optional existe desde o Java 8 e representa um container que
    * pode ou não conter um valor não nulo (diferente de null). Essa classe é bem interessante para evitar exceções do tipo
    * NullPointerException, e também permite fazer o uso dos métodos da classe Optional que simulam a programação funcional.
    * Com o retorno do método do método findAll da interface JpaRepository podemos fazer o uso do método map caso o valor
    * retornado seja diferente de nulo. O método map transforma (mapeia) o registro retornado em um tipo ResponseEntity.
    * Existe também a diferença no tipo do retorno dos métodos no controller.
    * Equanto to findAll retorna uma lista diretamente, o método findById  retorna um ResponseEntity para indicar sucesso ou não.
    * */
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse((ResponseEntity.notFound().build()));
    }

    /*
    * Criando um novo contato
    * hama o método save da interface JpaRepository.
    * Após criar o registro na tabela, retorna o contato com o atributo id populado
    * e o registro é retornado no corpo de resposta.
    * A anotação @RequestBody indica que o parâmetro contact será vinculado do corpo da requisição.
    * Isso significa que o método espera o seguinte conteúdo do corpo da requisição (em formato JSON):
    *
    * {
    *    "name": "Java",
    *    "email": "java@email.com",
    *    "phone": "(111) 111-1111"
    * }
    * */
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return repository.save(contact);
    }

    /*
    * Atualizando um contato
    * Para atualizar um registro, é necessário informar seu ID no caminho da URL
    * (similar ao processo de obter um registro específico). Caso deseje usar um nome de variável
    * diferente do que foi utilizado também pode utilizar o seguinte código @PathVariable("recordID") long id,
    * desde que otherID também seja o nome em @PutMapping(value="/{otherID}").
    * Além do ID, também é necessário passar o objeto com os dados atualizados.
    * O próximo passo é encontrar o registro a ser atualiza que está na base de dados.
    * Se o registro for encontrado, pode-se fazer as atualizações necessárias e assim chamar o método save e
    * retornar os dados do registro atualizados. Note que o método save também foi utilizado na criação do registro.
    * Caso o objeto tenha sido recuperado da base tenha um ID, será realizado um update e não um insert na tabela.
    * Caso não seja encontrato, retorna o erro HTTP 404
    * Um ponto importante para esse método (e também para o processo de criação de registros) é que a própria classe
    * de entidade JPA está sendo utilizada como objeto do tipo parâmetro. Não é uma prática recomendada utilizar a
    * entidade JPA como um objeto de transferência (ou DTO: Data Transfer Object). É sempre bom evitar expor o modelo
    * da base diretamente para o cliente da API. Para esse caso, pode-se criar uma classe com todos os atributos da
    * classe Contact, exceto o atributo id (ou uma classe com atributos que facilite a manipulação dos dados por um
    * front-end por exemplo).
    * Pode-se ainda desenvolver uma série de validações para melhorar esse código. Por exemplo, pode-se adicionar uma
    * validação para garantir que o id do registro passado como parâmetro é o mesmo id passado na URL.
    * Pode-se também utilizar a API Java Beans para aplicar validações de tamanho de campo, obrigatoriedade de
    * atributos, etc. É aqui que entrar toda a lógica de negócio necessária para a aplicação funcionar da forma que se é esperado.
    * */
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Contact contact){
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*
    * Remover um contato por Id
    * Para remover um contato pelo ID, utiliza-se o id que foi passado como parâmetro para procurar se o registro existe
    * na base. Caso exista, utiliza-se o método deleteById da interface JpaRepository e retorna o status HTTP 200 para
    * indicar sucesso. Caso o registro não exista, retorna um erro HTTP 404.
    * */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable long id){
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

/* A anotação @RestController contém as anotações @Controller e @ResponseBody. A anotação controller representa
* uma classe com endpoints (URIs que serão expostas pela API) e a classe que indica que o valor retornado
* pelos métodos devem ser vinculados ao corpo da resposta (response body)
* A anotação @RequestMapping("/contacts") indica que a URL da API desse controller começa com /contacts,
* isso significa que pode-se acessar usando a URL http://localhost:8080/contacts (acesso local).
*
* Como o controller irá acessar o repositório diretamente (como este é um exemplo simples, a camada de serviço está sendo omitida,
* porém é sempre uma boa prática usar uma classe Service que evoca o repositório e contém a lógica de negócio do projeto para deixar
* o código da classe controller enxuto e mais limpo), é necessário declarar o repositório como atributo. */