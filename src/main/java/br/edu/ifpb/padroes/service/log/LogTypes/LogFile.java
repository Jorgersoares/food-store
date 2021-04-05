package br.edu.ifpb.padroes.service.log.LogTypes;

import br.edu.ifpb.padroes.service.log.Log;

public class LogFile implements Log {
    @Override
    public void log(String message) {
        System.out.println("save data to a file");
    }
}
