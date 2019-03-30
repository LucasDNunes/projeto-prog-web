package br.unisul.progweb.config;

import br.unisul.progweb.domain.categoria.Categoria;
import br.unisul.progweb.domain.categoria.CategoriaRepository;
import br.unisul.progweb.domain.cidade.Cidade;
import br.unisul.progweb.domain.cidade.CidadeRepository;
import br.unisul.progweb.domain.cliente.Cliente;
import br.unisul.progweb.domain.cliente.ClienteRepository;
import br.unisul.progweb.domain.cliente.TipoCliente;
import br.unisul.progweb.domain.endereco.Endereco;
import br.unisul.progweb.domain.endereco.EnderecoRepository;
import br.unisul.progweb.domain.estado.Estado;
import br.unisul.progweb.domain.estado.EstadoRepository;
import br.unisul.progweb.domain.produto.Produto;
import br.unisul.progweb.domain.produto.ProdutopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

@Service
public class DbService {

    private final CategoriaRepository categoriaRepository;
    private final ProdutopRepository produtopRepository;
    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public DbService(CategoriaRepository categoriaRepository,
                     ProdutopRepository produtopRepository,
                     EstadoRepository estadoRepository,
                     CidadeRepository cidadeRepository,
                     ClienteRepository clienteRepository,
                     EnderecoRepository enderecoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtopRepository = produtopRepository;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void inicializaBancoDeDados() throws ParseException {

        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");
        Categoria cat3 = new Categoria("Cama mesa e banho");
        Categoria cat4 = new Categoria("Eletrônicos");
        Categoria cat5 = new Categoria("Jardinagem");
        Categoria cat6 = new Categoria("Decoração");
        Categoria cat7 = new Categoria("Perfumaria");

        Estado e1 = new Estado("Paraná", "PR");
        Estado e2 = new Estado("Santa Catarina", "SC");
        Estado e3 = new Estado("Rio Grande do Sul", "RS");

        Cidade c1 = new Cidade(null, "Curitiba", e1);
        Cidade c2 = new Cidade(null, "Tubarão", e2);
        Cidade c3 = new Cidade(null, "Gravatal", e2);
        Cidade c4 = new Cidade(null, "Laguna", e2);
        Cidade c5 = new Cidade(null, "Porto Alegre", e3);
        Cidade c6 = new Cidade(null, "Guaíba", e3);

        e1.getCidades().addAll(Collections.singletonList(c1));
        e2.getCidades().addAll(Arrays.asList(c2, c3, c4));
        e3.getCidades().addAll(Arrays.asList(c5, c6));

        Cliente cliente = new Cliente(null, "Lucas", "Lucas@Teste", "01275665", TipoCliente.PF);
        cliente.getTelefones().addAll(Arrays.asList("12345678", "87654321"));

        Endereco endereco1 = new Endereco(null, "logradouro teste 1", "123",
                "", "centro", "88701440", cliente, c2);
        Endereco endereco2 = new Endereco(null, "logradouro teste 2", "1234", "rua de complemento",
                "centro", "88701330", cliente, c3);
        cliente.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

        estadoRepository.saveAll(Arrays.asList(e1, e2, e3));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

        clienteRepository.save(cliente);
        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));


        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);
        p1.getCategorias().addAll(Collections.singletonList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Collections.singletonList(cat1));
        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Collections.singletonList(p2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtopRepository.saveAll(Arrays.asList(p1, p2, p3));
    }

}
