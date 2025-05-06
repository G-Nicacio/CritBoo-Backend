package br.edu.insper.CritBoo.Jogo.Estudio;

public class EstudioDTO {
    private Integer id;
    private String nomeEstudio;
    private String dataFundacao;
    private String imagem;
    private String descricao;

    public EstudioDTO(Estudio estudio) {
        this.id = estudio.getId();
        this.nomeEstudio = estudio.getNomeEstudio();
        this.dataFundacao = estudio.getDataFundacao().toString(); // Ou usar formatter se quiser
        this.imagem = estudio.getImagem();
        this.descricao = estudio.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeEstudio() {
        return nomeEstudio;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }
}
