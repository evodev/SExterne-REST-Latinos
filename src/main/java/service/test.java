package service;

import java.io.IOException;

import java.math.BigInteger;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import presentation.MyContract;

public class test {
  public static void generateContract() {

    long chainId = 3;

    Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"), chainId,new ScheduledThreadPoolExecutor(5));
    //Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
    String contractAddress = "0xd9145CCE52D386f254917e481eB44e9943F39138";

    try {

      // web3_clientVersion returns the current client version.
      Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

      //eth_blockNumber returns the number of most recent block.
      EthBlockNumber blockNumber = web3.ethBlockNumber().send();

      //eth_gasPrice, returns the current price per gas in wei.
      EthGasPrice gasPrice = web3.ethGasPrice().send();
      System.out.println("MA CHAINE ID " + web3.ethChainId().getId());

      ContractGasProvider contractGasProvider = new DefaultGasProvider();


      System.out.println("gasprice: " + gasPrice.getGasPrice());
      System.out.println("blocknumber : " + blockNumber.getBlockNumber());
      System.out.println("clientversion : " + clientVersion.getWeb3ClientVersion());
      //MyContract contract = MyContract.deployRemoteCall(contractAddress, web3, new Credentials(<votre>), contractGasProvider, contractABI);

      // load private key into eckey to sign
      String privatekey = "503f38a9c967ed597e47fe25643985f032b072db8075426a92110f82df48dfcb";
      //BigInteger privkey = new BigInteger(privatekey, 16);
      //ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
      //Credentials credentials = Credentials.create(ecKeyPair);
      Credentials credentials = Credentials.create(privatekey);

      MyContract contract = MyContract.load(contractAddress, web3, Credentials.create(privatekey), contractGasProvider);

      BigInteger minuteNum = BigInteger.valueOf(35);
      BigInteger minutaireNum = BigInteger.valueOf(35);
      //TransactionReceipt transactionReceipt = contract.setRecord("12.09.1996", "marco", minuteNum, minutaireNum, "test" ).send();
      //System.out.println(contract.getRecord(BigInteger.valueOf(1)).send());
      System.out.println(contract.getContractAddress());
      //MyContract contract = MyContract.
    } catch (
        IOException ex) {
      throw new RuntimeException("Error whilst sending json-rpc requests", ex);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
