package service;

import java.math.BigInteger;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import presentation.MyContract;

public class test {
  public static void generateContract() {
    //chainId de Mumbai
    long chainId = 80001;
    // Url RPC de mumbai
    String contractAddress = "0x5c601274479459594F710B6f6D87e5a75117D681";
    // clef privé du createur du contrat !!A SECURISER LORS D'UN REEL PROJET!!
    String privatekey = "f37c0873affb8ff2b8b7378acc779bd23e5d3c3b6a20d89bf628807fec082d0c";

    Web3j web3 = Web3j.build(new HttpService("https://rpc-mumbai.maticvigil.com"));

    try {
      ContractGasProvider contractGasProvider = new DefaultGasProvider();

      Credentials credentials = Credentials.create(privatekey);

      TransactionManager transactionManager = new RawTransactionManager(web3, credentials, chainId);

      MyContract contract = MyContract.load(contractAddress, web3, transactionManager, contractGasProvider);
      BigInteger minuteNum = BigInteger.valueOf(35);
      BigInteger minutaireNum = BigInteger.valueOf(35);


      String record1 = String.valueOf(contract.getRecord(BigInteger.valueOf(3)).send());
      System.out.println(record1);

      TransactionReceipt setRecord1 = contract.setRecord("12.09.1996", "marco", minuteNum, minutaireNum, "test" ).send();
      System.out.println(setRecord1.getTransactionHash());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
