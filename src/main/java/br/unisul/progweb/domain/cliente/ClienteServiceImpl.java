package br.unisul.progweb.domain.cliente;

import br.unisul.progweb.controller.dto.ClienteNewDto;
import br.unisul.progweb.core.support.service.AbstractService;
import br.unisul.progweb.domain.cidade.Cidade;
import br.unisul.progweb.domain.endereco.Endereco;
import br.unisul.progweb.domain.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl extends AbstractService<Cliente, Long, ClienteRepository> implements ClienteService {

    private final EnderecoService enderecoService;

    @Autowired
    public ClienteServiceImpl(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Override
    public Cliente fromDTO(ClienteNewDto objDto) {
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2() != null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3() != null) {
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }

    @Override
    @Transactional
    public Cliente salvar(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        obj.getEnderecos().forEach(enderecoService::salvar);
        return obj;
    }

    public Cliente findByEmail(String email) {
        Cliente obj = repo.findByEmail(email);
        return obj;
    }

}
