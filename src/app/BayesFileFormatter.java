//BEGIN_HIP;                                        //  \n + $BEGIN_HIP + ; + \n +
//local;                                            //  hyp.getNodeNome + ; + \n +
//quarto1, quarto2, corredor1, corredor2;           //  hS(i).name + , + space + hS(i+1).name + , + space + hS(i+2).name + , + space + hS(i+3).name + ; + \n +
//0.55, 0.1, 0.25, 0.1;                             //  hS(i).prob + , + space + hS(i+1).prob + , + space + hS(i+2).prob + , + space + hS(i+3).prob + ; + \n +
//END_HIP;                                          //  $END_HIP + ; + \n +
//                                                  //  \n
//BEGIN_EVI;                                        //  $BEGIN_EVI + ; + \n +
//barulho;                                          //  evid(k).nodeName + ; + \n +
//baixo, alto;                                      //  eS(kJ).name + , + space + eS(kJ+1).name + ; + \n +
//0.8, 0.85, 0.4, 0.3 # 0.2, 0.15, 0.6, 0.7;        //  eS(j).prob_hS(i) + , + space + eS(j).prob_hS(i+1) + , + space + eS(j).prob_hS(i+2) + , + space + eS(j).prob_hS(i+3)
                                                    //  + # +
                                                    //  eS(j+1).prob_hS(i) + , + space + eS(j+1).prob_hS(i+1) + , + space + eS(j+1).prob_hS(i+2) + , + space + eS(j+1).prob_hS(i+3)
                                                    //  + ; + \n
//END_EVI;                                          //  $END_EVI; + \n +
//                                                  //  \n
//BEGIN_EVI;                                        //  $BEGIN_EVI + ; + \n +
//iluminacao;                                       //  evid(k+1).nodeName + ; + \n +
//claro, escuro;                                    //  eS(k+1j).name + , + space + eS(k+1j+1).name + ; + \n +
//0.65, 0.51, 0.55, 0.45 # 0.35, 0.49, 0.45, 0.55;  //  eS(j).prob_hS(i) + , + space + eS(j).prob_hS(i+1) + , + space + eS(j).prob_hS(i+2) + , + space + eS(j).prob_hS(i+3)
                                                    //  + # +
                                                    //  eS(j+1).prob_hS(i) + , + space + eS(j+1).prob_hS(i+1) + , + space + eS(j+1).prob_hS(i+2) + , + space + eS(j+1).prob_hS(i+3)
                                                    //  + ; + \n
//END_EVI;                                          //  $END_EVI; + \n

package app;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Senna
 */
public class BayesFileFormatter
{    
    // Blocos textuais para a construção do arquivo de texto referente à rede bayesiana modelada via UI
    
    private final String BEGIN_HIP = "BEGIN_HIP" ;
    private final String END_HIP = "END_HIP" ;
    private final String SPACE = " " ;                              // Não há certeza se será usado
    private final String NEXT_LINE = "\n" ;
//    private final String TAB = "\t" ;
    private final String BEGIN_EVI = "BEGIN_EVI" ;
    private final String END_EVI = "END_EVI" ;
    private final String HASHTAG = "#" ;
//    private final String REAL = "REAL" ;
    private final String SEMICOLON = ";" ;
//    private final String END_VAR = "END_VAR" ;
//    private final String FUZZIFY = "FUZZIFY" ;
//    private final String TERM = "TERM" ;
//    private final String EQUAL = "=" ;
//    private final String COLON_EQUAL = this.COLON + this.EQUAL ;    // ":="
//    private final String PARENTHESIS_OPEN = "(" ;
//    private final String PARENTHESIS_CLOSE = ")" ;
    private final String COMMA = "," ;
//    private final String END_FUZZIFY = "END_FUZZIFY" ;    
//    private final String END_FUNCTION_BLOCK = "END_FUNCTION_BLOCK" ;
//        
//    public ArrayList<FunctionKind> functionDefinitions = new ArrayList<FunctionKind>();
    
    // Nomes expositivos dos tipos de função de pertinência aplicáveis aos conjuntos fuzzy (estadosFuzzy)
//    public static final String FUNC_NAME_DEFAULT = "Default" ;  // Se for default, permite a criação de 2 ou mais pontos
    
//    public static final String FUNC_NAME_TRAPE = "Trapezoidal" ;      // Se for "trape", de trapezoidal, representa uma função com apenas 4 pontos
//    public static final String FUNC_NAME_TRIAN = "Triangular" ;      // Se for "trian", de triangular, representa uma função com apenas 3 pontos
//    public static final String FUNC_NAME_GAUSS = "Gaussiana" ;      // Se for "gauss", de gaussiana, representa uma função com apenas 2 pontos
//    public static final String FUNC_NAME_GBELL = "Sino" ;      // Se for "gbell", de sino, representa uma função com apenas 3 pontos
//    public static final String FUNC_NAME_SIGM = "Sigmoidal" ;        // Se for "sigm", de sigmoidal, representa uma função com apenas 2 pontos
    
    // Tipos de função de pertinência (na forma em que devem ser adicionados ao arquivo .fcl)
//    public static final String FUNC_TYPE_DEFAULT = "default" ;  // Se for default, permite a criação de 2 ou mais pontos
    
//    public static final String FUNC_TYPE_TRAPE = "trape" ;      // Se for "trape", de trapezoidal, representa uma função com apenas 4 pontos
//    public static final String FUNC_TYPE_TRIAN = "trian" ;      // Se for "trian", de triangular, representa uma função com apenas 3 pontos
//    public static final String FUNC_TYPE_GAUSS = "gauss" ;      // Se for "gauss", de gaussiana, representa uma função com apenas 2 pontos
//    public static final String FUNC_TYPE_GBELL = "gbell" ;      // Se for "gbell", de sino, representa uma função com apenas 3 pontos
//    public static final String FUNC_TYPE_SIGM = "sigm" ;        // Se for "sigm", de sigmoidal, representa uma função com apenas 2 pontos  

//    private InputHandler reader ;
    
    private MainScreen mainScreen;
    
    public BayesFileFormatter()
    {
//        this.setFunctionTypes();
    }

    public MainScreen getMainScreen()
    {
        return mainScreen;
    }

    public void setMainScreen(MainScreen mainScreen)
    {
        this.mainScreen = mainScreen;
    }

    
    
//    public void setFunctionTypes()
//    {
////        functionDefinitions.add(new FunctionKind (FUNC_NAME_DEFAULT, 2)); 
//        
//        functionDefinitions.add(new FunctionKind (FUNC_NAME_TRAPE, 4));
//        functionDefinitions.add(new FunctionKind (FUNC_NAME_TRIAN, 3));
//        functionDefinitions.add(new FunctionKind (FUNC_NAME_GAUSS, 2));
//        functionDefinitions.add(new FunctionKind (FUNC_NAME_GBELL, 3));
//        functionDefinitions.add(new FunctionKind (FUNC_NAME_SIGM, 2));
//    }

//    public ArrayList<FunctionKind> getFunctionDefinitions() {
//        return functionDefinitions;
//    }
//
//    public void setFunctionDefinitions(ArrayList<FunctionKind> functionDefinitions) {
//        this.functionDefinitions = functionDefinitions;
//    }
    
     public String getBayesToText()
    {
        String s = "";
        String nLine = this.NEXT_LINE ;     // "\n"
        String spc = this.SPACE;            // " "
        String semiCol = this.SEMICOLON ;   // ";"
        String comma = this.COMMA ;         // ","
        String hash = this.HASHTAG ;        // "#"
        
        Hypothesis hyp = this.mainScreen.getHypNode().getHypothesis();
        ArrayList<HypothesisState> hypStates = hyp.getHypStates();
        ArrayList<Evidence> bayesEvids = hyp.getBayesEvids();
        
        // Monta o cabeçalho (primeira linha do arquivo)
        s += nLine + nLine + this.BEGIN_HIP + semiCol + nLine ;
        
        // Insere o nome da Hipótese
        s += hyp.getNodeName() + semiCol + nLine ;
        
        // Armazena as probs dos estados e as adiciona conforme os estados são lidos
        String hypStateProbs = "" ;
        
        // Agora percorre os estados da hipotese
        for ( HypothesisState hs : hypStates )
        {
            if ( hs == hypStates.get(hypStates.size()-1))
            {
                s += hs.getNameHypState() + semiCol + nLine;
                hypStateProbs += hs.getProb_Hyp() + semiCol + nLine;
                s += hypStateProbs ;
            }
            else
            {
                s += hs.getNameHypState() + comma + spc ;
                hypStateProbs += hs.getProb_Hyp() + comma + spc ;
            }
        }
        
        // Aqui, foi encerrada a criação do nodo de hipótese
        s += this.END_HIP + semiCol + nLine ;
        
        // Espera montar as declarações de evidências
        for ( Evidence evid : bayesEvids )
        {
            // Inicia o bloco de uma evidencia
            s += nLine + this.BEGIN_EVI + semiCol + nLine ;
        
            // Insere o nome da Evidencia
            s += evid.getNodeName() + semiCol + nLine ;
            
            // Armazena os estados da evidencia atual
            ArrayList<EvidenceState> evidStates = evid.getEvidenceStates() ;
            
            // Vai acumulando as probs dos estados da evidencia
            String evidStateProbs = "" ;
            
            // Agora percorre os estados da evidencia
            for ( EvidenceState es : evidStates )
            {
                // Verifica se é o ultimo estado, para adicionar ";" ao final de sua linha
                if ( es == evidStates.get(evidStates.size()-1))
                {
                    // Adiciona o nome do estado ao texto, com ";" no final
                    s += es.getNameEvidState() + semiCol + nLine;
                    
                    // Armazena as probs do estado atual
                    ArrayList<Float> stateProbs = es.getProbs_Evid_given_Hyp();
                    
                    // TESTE
                    System.out.println("\n\t\t>>>QUANTIDADE DE probs do estado " 
                            + es.getNameEvidState() + ": " + stateProbs.size()
                            + "\n\t\t>>>PROBS: " + stateProbs.toString());
                    
                    // Percorre as probs do estado atual
                    for ( int i = 0 ; i < stateProbs.size() ; i++ )
                    {
                        // Conta as probs ja lidas
//                        int i = 0 ;
                        
                        // Verifica se é a última prob do último estado, para inserir ";" no final da linha
                        if ( i == stateProbs.size()-1 )
                        {
                            // Adiciona essa última probabilidade ao coletor de probs
                            evidStateProbs += stateProbs.get(i) + semiCol + nLine;
                            
                            // Adiciona todas as probs lidas ao texto
                            s += evidStateProbs ;
                        }
                        else
                        {
                            // Como não foi a última prob lida, adiciona apenas "," e "espaço" ao coletor de probs
                            evidStateProbs += stateProbs.get(i) + comma + spc;
                        }
//                        i++;
                    }
                }
                else
                {
                    // Como não foi o último estado lido, adiciona o nome do estado e apenas "," e "espaço" ao texto
                    s += es.getNameEvidState() + comma + spc;
                    
                    // Armazena as probs do estado atual
                    ArrayList<Float> stateProbs2 = es.getProbs_Evid_given_Hyp();
                    
                    
                    // TESTE
                    System.out.println("\n\t\t>>>QUANTIDADE DE probs do estado " 
                            + es.getNameEvidState() + ": " + stateProbs2.size()
                            + "\n\t\t>>>PROBS: " + stateProbs2.toString());
                    
                    // Percorre as probs do estado atual
                    for ( int i = 0 ; i < stateProbs2.size() ; i++ )
                    {
                        // Conta as probs já lidas
//                        int i = 0 ;
                        
                        // Verifica se é a última prob de um estado que não é o último, para inserir "#"
                        // e aguardar as probs do estado seguinte
                        if ( i == stateProbs2.size()-1 )
                        {
                            // Adiciona a probabilidade + "espaço" + "#" + "espaço" ao coletor de probs
                            evidStateProbs += stateProbs2.get(i).toString() + spc + hash + spc ;
                        }
                        else
                        {
                            // Como não foi a última prob lida, adiciona apenas "," e "espaço" ao coletor de probs
                            evidStateProbs += stateProbs2.get(i).toString() + comma + spc;
                        }
//                        i++;
                    }                   
                }
            }
            // Aqui, foi encerrada a criação de um bloco de evidência
            // Se não houverem outras evidências, o texto Bayes está completo
            s += this.END_EVI + semiCol + nLine ;            
        }                
        return s;
    }
    
    
//     public String getBayesToText()
//    {
//        String s = "";
//        String nLine = this.NEXT_LINE ;     // "\n"
//        String spc = this.SPACE;            // " "
//        String semiCol = this.SEMICOLON ;   // ";"
//        String comma = this.COMMA ;         // ","
//        String hash = this.HASHTAG ;        // "#"
//        
//        Hypothesis hyp = this.mainScreen.getHypNode().getHypothesis();
//        ArrayList<HypothesisState> hypStates = hyp.getHypStates();
//        ArrayList<Evidence> bayesEvids = hyp.getBayesEvids();
//        
//        // Monta o cabeçalho (primeira linha do arquivo)
//        s += nLine + nLine + this.BEGIN_HIP + semiCol + nLine ;
//        
//        // Insere o nome da Hipótese
//        s += hyp.getNodeName() + semiCol + nLine ;
//        
//        // Armazena as probs dos estados e as adiciona conforme os estados são lidos
//        String hypStateProbs = "" ;
//        
//        // Agora percorre os estados da hipotese
//        for ( HypothesisState hs : hypStates )
//        {
//            if ( hs == hypStates.get(hypStates.size()-1))
//            {
//                s += hs.getNameHypState() + semiCol + nLine;
//                hypStateProbs += hs.getProb_Hyp() + semiCol + nLine;
//                s += hypStateProbs ;
//            }
//            else
//            {
//                s += hs.getNameHypState() + comma + spc ;
//                hypStateProbs += hs.getProb_Hyp() + comma + spc ;
//            }
//        }
//        
//        // Aqui, foi encerrada a criação do nodo de hipótese
//        s += this.END_HIP + semiCol + nLine ;
//        
//        // Espera montar as declarações de evidências
//        for ( Evidence evid : bayesEvids )
//        {
//            // Inicia o bloco de uma evidencia
//            s += nLine + this.BEGIN_EVI + semiCol + nLine ;
//        
//            // Insere o nome da Evidencia
//            s += evid.getNodeName() + semiCol + nLine ;
//            
//            // Armazena os estados da evidencia atual
//            ArrayList<EvidenceState> evidStates = evid.getEvidenceStates() ;
//            
//            // Vai acumulando as probs dos estados da evidencia
//            String evidStateProbs = "" ;
//            
//            // Agora percorre os estados da evidencia
//            for ( EvidenceState es : evidStates )
//            {
//                // Verifica se é o ultimo estado, para adicionar ";" ao final de sua linha
//                if ( es == evidStates.get(evidStates.size()-1))
//                {
//                    // Adiciona o nome do estado ao texto, com ";" no final
//                    s += es.getNameEvidState() + semiCol + nLine;
//                    
//                    // Armazena as probs do estado atual
//                    ArrayList<Float> stateProbs = es.getProbs_Evid_given_Hyp();
//                    
//                    // TESTE
//                    System.out.println("\n\t\t>>>QUANTIDADE DE probs do estado " 
//                            + es.getNameEvidState() + ": " + stateProbs.size()
//                            + "\n\t\t>>>PROBS: " + stateProbs.toString());
//                    
//                    // Percorre as probs do estado atual
//                    for ( Float prob : stateProbs )
//                    {
//                        // Conta as probs ja lidas
//                        int i = 0 ;
//                        
//                        // Verifica se é a última prob do último estado, para inserir ";" no final da linha
//                        if ( i == stateProbs.size()-1 )
//                        {
//                            // Adiciona essa última probabilidade ao coletor de probs
//                            evidStateProbs += prob.toString() + semiCol + nLine;
//                            
//                            // Adiciona todas as probs lidas ao texto
//                            s += evidStateProbs ;
//                        }
//                        else
//                        {
//                            // Como não foi a última prob lida, adiciona apenas "," e "espaço" ao coletor de probs
//                            evidStateProbs += prob.toString() + comma + spc;
//                        }
//                        i++;
//                    }
//                }
//                else
//                {
//                    // Como não foi o último estado lido, adiciona o nome do estado e apenas "," e "espaço" ao texto
//                    s += es.getNameEvidState() + comma + spc;
//                    
//                    // Armazena as probs do estado atual
//                    ArrayList<Float> stateProbs2 = es.getProbs_Evid_given_Hyp();
//                    
//                    
//                    // TESTE
//                    System.out.println("\n\t\t>>>QUANTIDADE DE probs do estado " 
//                            + es.getNameEvidState() + ": " + stateProbs2.size()
//                            + "\n\t\t>>>PROBS: " + stateProbs2.toString());
//                    
//                    // Percorre as probs do estado atual
//                    for ( Float prob : stateProbs2 )
//                    {
//                        // Conta as probs já lidas
//                        int i = 0 ;
//                        
//                        // Verifica se é a última prob de um estado que não é o último, para inserir "#"
//                        // e aguardar as probs do estado seguinte
//                        if ( i == stateProbs2.size()-1 )
//                        {
//                            // Adiciona a probabilidade + "espaço" + "#" + "espaço" ao coletor de probs
//                            evidStateProbs += prob.toString() + spc + hash + spc ;
//                        }
//                        else
//                        {
//                            // Como não foi a última prob lida, adiciona apenas "," e "espaço" ao coletor de probs
//                            evidStateProbs += prob.toString() + comma + spc;
//                        }
//                        i++;
//                    }                   
//                }
//            }
//            // Aqui, foi encerrada a criação de um bloco de evidência
//            // Se não houverem outras evidências, o texto Bayes está completo
//            s += this.END_EVI + semiCol + nLine ;            
//        }                
//        return s;
//    }
//    
    
}
