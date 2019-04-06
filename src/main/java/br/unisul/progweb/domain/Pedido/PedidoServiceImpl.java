package br.unisul.progweb.domain.Pedido;

import br.unisul.progweb.core.exception.RegistroNaoEncontradoException;
import br.unisul.progweb.core.support.service.AbstractService;
import br.unisul.progweb.domain.cliente.ClienteService;
import br.unisul.progweb.domain.itempedido.ItemPedido;
import br.unisul.progweb.domain.itempedido.ItemPedidoService;
import br.unisul.progweb.domain.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PedidoServiceImpl extends AbstractService<Pedido, Long, PedidoRepository> {

    private final ItemPedidoService itemPedidoService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    @Autowired
    public PedidoServiceImpl(ItemPedidoService itemPedidoService,
                             ClienteService clienteService,
                             ProdutoService produtoService) {
        this.itemPedidoService = itemPedidoService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    @Override
    public Pedido salvar(Pedido obj) {
        obj.setInstante(new Date());
        obj.setCliente(clienteService.buscarPorId(obj.getCliente().getId())
                .orElseThrow(() -> new RegistroNaoEncontradoException("Cliente", 1)));
        obj = repo.save(obj);

        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.buscarPorId(ip.getProduto().getId()).orElse(null));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        obj.getItens().forEach(itemPedidoService::salvar);
        return obj;
    }

}
