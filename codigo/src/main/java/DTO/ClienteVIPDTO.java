package DTO;

public class ClienteVIPDTO implements ClienteDTO {
    private Long id;
    private String name;
    private String email;
    private double taxaVip;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public double getTaxaVip() {
        return taxaVip;
    }

    public void setTaxaVip(double taxaVip) {
        this.taxaVip = taxaVip;
    }
}