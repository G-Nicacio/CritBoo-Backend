package br.edu.insper.CritBoo.Usuario;


import java.util.HashMap;

public class HistoricoService {
    private HashMap<Integer, Historico> historico = new HashMap<>();

    public HashMap<Integer, Historico> getHistorico(){
        return  historico;
    }

    public Historico getHistorico(Integer id) {
        return historico.get(id);
    }

}
