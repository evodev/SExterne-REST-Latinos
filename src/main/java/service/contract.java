package service;

import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;


public class contract {
  public static MySmartContract mySmartContract;
  public static void connectContract() {
    //chainId de Mumbai
    long chainId = 80001;
    // L'adresse du contrat déployé
    String contractAddress = "0x392C5eA40Dce3553aE6Fb7Ce9b44033F6532C1DD";
    // clef privé du createur du contrat !!A SECURISER LORS D'UN REEL PROJET!!
    String privatekey = "f37c0873affb8ff2b8b7378acc779bd23e5d3c3b6a20d89bf628807fec082d0c";
    // URL du RPC de Mumbai
    Web3j web3 = Web3j.build(new HttpService("https://rpc-mumbai.maticvigil.com"));

    try {
      ContractGasProvider contractGasProvider = new DefaultGasProvider();

      Credentials credentials = Credentials.create(privatekey);

      TransactionManager transactionManager = new RawTransactionManager(web3, credentials, chainId);

      mySmartContract = MySmartContract.load(contractAddress, web3, transactionManager, contractGasProvider);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static String setRecord(String pAnneeNaissance, String pSignature, Integer pMinuteNum, Integer pMinutaireNum, String pDesignation) throws Exception {
    BigInteger minuteNum = BigInteger.valueOf(pMinuteNum);
    BigInteger minutaireNum = BigInteger.valueOf(pMinutaireNum);

    TransactionReceipt setRecord = mySmartContract.setRecord(pAnneeNaissance, pSignature, minuteNum, minutaireNum, pDesignation).send();

    return setRecord.getTransactionHash();
  }

  public static String getRecord(int pId) throws Exception {
    String record = String.valueOf(mySmartContract.getRecord(BigInteger.valueOf(pId)).send());
    return record;
  }

}
