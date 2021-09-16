package dio.springperson.mts.exceptions;

public class ConteudoNaoExistenteException extends RuntimeException {

    public ConteudoNaoExistenteException(Object id) {
        super("Conteudo com id " + id + " nao existe no banco de dados");
    }
}
