package service;

import java.io.IOException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

public class test {
  public static void generateContract() {
    Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));

    try {
      // web3_clientVersion returns the current client version.
      Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

      //eth_blockNumber returns the number of most recent block.
      EthBlockNumber blockNumber = web3.ethBlockNumber().send();

      //eth_gasPrice, returns the current price per gas in wei.
      EthGasPrice gasPrice = web3.ethGasPrice().send();

      System.out.println(gasPrice.getGasPrice());
    } catch (
        IOException ex) {
      throw new RuntimeException("Error whilst sending json-rpc requests", ex);
    }
  }

}
