package service;

import java.io.IOException;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import presentation.MyContract;
//import org.web3j.contracts.*;
//import org.web3j.tx.Contract;

public class test {
  public static void generateContract() {
    Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
    String contractAddress = "0xd9145CCE52D386f254917e481eB44e9943F39138";

    try {

      // web3_clientVersion returns the current client version.
      Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

      //eth_blockNumber returns the number of most recent block.
      EthBlockNumber blockNumber = web3.ethBlockNumber().send();

      //eth_gasPrice, returns the current price per gas in wei.
      EthGasPrice gasPrice = web3.ethGasPrice().send();

      System.out.println("gasprice: " + gasPrice.getGasPrice());
      System.out.println("blocknumber : " + blockNumber.getBlockNumber());
      System.out.println("clientversion : " + clientVersion.getWeb3ClientVersion());
      MyContract contract = MyContract.deployRemoteCall(contractAddress, web3, new Credentials(<votre>), contractGasProvider, contractABI);
      //TransactionReceipt transactionReceipt = contract.setRecord("Hello, world!").send();

      //MyContract contract = MyContract.
    } catch (
        IOException ex) {
      throw new RuntimeException("Error whilst sending json-rpc requests", ex);
    }
  }

}
