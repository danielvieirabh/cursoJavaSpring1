package com.projeto.curso.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUtoIncremeto para ID
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imgUrl;

    @ManyToMany // MUitos para muitos
    @JoinTable(name = "tb_product_category", //Criar uma tabela a parte
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id") //O inverso de JoinColummn vai ser category
    )
    private Set<Category> categories = new HashSet<>(); //Set = conjunto , O mesmo produto nao pode ter a mesma categoria , mais de uma vez , E COMECAR VAZIA

    @OneToMany(mappedBy = "id.product") //Id da classe OrderItem
    private Set<OrderItem> items = new HashSet<>(); //Set e para informar ao Jpa para nao ter repetiçoes do mesmo item

    public Product() {

    }

    public Product(Long id, String nome, String descricao, Double preco, String imgUrl ) { //Nao coloca colecoes de SET no construtor
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() { //Nao pode ter set
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders() { //Nao pode ter set
        Set<Order> setOrder = new HashSet<>();
        for (OrderItem orderItem : items) {
            setOrder.add(orderItem.getOrder()); //Para cada elemento dessa colecao , irei adicionar o os pedidos
        }
        return setOrder;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
