package br.edu.ifpb.padroes.service.log;

public interface Log {

    public void log(String message);



//    public LogHandler(LogHandlerType type) {
//        this.type = type;
//    }
//
//    public enum LogHandlerType { DATABASE, FILE}
//
//    private LogHandlerType type;
//
//    public void log(String message) {
//        if (type.equals(LogHandlerType.DATABASE)) {
//            System.out.println("save data to database");
//        } else if (type.equals(LogHandlerType.FILE)) {
//            System.out.println("save data to a file");
//        }
//    }

}
