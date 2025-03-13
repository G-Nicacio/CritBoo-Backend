package br.edu.insper.CritBoo.Jogo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EstudioService {
    private HashMap<String, Estudio> estudios = new HashMap<>();

    public HashMap<String, Estudio> getEstudios() {
        return estudios;
    }

    public Estudio getEstudioEspecifico(String nomeEstudio) {
        return estudios.get(nomeEstudio);
    }

    public Estudio registrarEstudio(Estudio estudioRecebido) {
        if (estudioRecebido.getNomeEstudio() != null && (estudioRecebido.getNomeEstudio().equals("")) != true) {
            estudios.put(estudioRecebido.getNomeEstudio(), estudioRecebido);
            return estudioRecebido;
        }
        return null;
    }

    public Estudio removerEstudio(String nomeEstudio) {
        Estudio encontraEstudio = estudios.get(nomeEstudio);
        if (encontraEstudio != null) {
            estudios.remove(nomeEstudio);
        }
        return encontraEstudio;
    }

    public HashMap<String, Estudio> atualizarEstudio(String nomeEstudio, Estudio novoEstudio) {
        Estudio encontraEstudio = estudios.get(nomeEstudio);
        HashMap<String, Estudio> resposta = new HashMap<>();

        if (encontraEstudio != null) {
            resposta.put("Antigo", encontraEstudio);
            if (novoEstudio.getNomeEstudio() != null && (novoEstudio.getNomeEstudio().equals("")) != true) {
                resposta.put("Novo", novoEstudio);
                estudios.remove(nomeEstudio);
                estudios.put(novoEstudio.getNomeEstudio(), novoEstudio);

                return resposta;
            }
        }
        return null;
    }
}
