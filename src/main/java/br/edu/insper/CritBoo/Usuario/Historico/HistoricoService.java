package br.edu.insper.CritBoo.Usuario.Historico;


import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HistoricoService {
    private HashMap<Integer, Historico> historico = new HashMap<>();

    public HashMap<Integer, Historico> getHistorico(){
        return  historico;
    }

    public Historico getHistorico(Integer id) {
        return historico.get(id);
    }

}
