package Service;

public interface EnvolveMaisPessoas {
    default String envolveMaisPessoas(Boolean envolveMaisSimOuNao,String prompt) {
        if(envolveMaisSimOuNao){
            return prompt;
        }
        return null;
    }
}
