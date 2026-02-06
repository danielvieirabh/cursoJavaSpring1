package com.projeto.curso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.curso.entities.Order;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable { //SERIALIZIBLE = decidir quando os objetos pode ser trasnformados em bytes
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUtoIncremeto para ID
    private Long id;
    private String nome;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore //Para nao dar loop
    @OneToMany(mappedBy = "user") //Um para muitos , mapeado para user
    private List<Order> orders = new ArrayList<>(); //Lista de pedidos em uma coleção, e tabem somente usar o get

    public User() {
    }
    public User(Long id, String nome, String email, String phone , String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
