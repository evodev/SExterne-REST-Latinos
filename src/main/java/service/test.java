package service;

import java.io.IOException;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.contracts.*;
import org.web3j.tx.Contract;

public class test {
  public static void generateContract() {
    Web3j web3 = Web3j.build(new HttpService("http://localhost:8545"));
    String contractAddress = "0xd9145CCE52D386f254917e481eB44e9943F39138";
    String contractABI = "[\n" +
            "    {\n" +
            "        \"inputs\": [\n" +
            "            {\n" +
            "                \"internalType\": \"string\",\n" +
            "                \"name\": \"_date\",\n" +
            "                \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"string\",\n" +
            "                \"name\": \"_signature\",\n" +
            "                \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"uint256\",\n" +
            "                \"name\": \"_minuteNum\",\n" +
            "                \"type\": \"uint256\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"uint256\",\n" +
            "                \"name\": \"_minutaireNum\",\n" +
            "                \"type\": \"uint256\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"string\",\n" +
            "                \"name\": \"_designation\",\n" +
            "                \"type\": \"string\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"name\": \"setRecord\",\n" +
            "        \"outputs\": [],\n" +
            "        \"stateMutability\": \"nonpayable\",\n" +
            "        \"type\": \"function\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"inputs\": [\n" +
            "            {\n" +
            "                \"internalType\": \"uint256\",\n" +
            "                \"name\": \"_id\",\n" +
            "                \"type\": \"uint256\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"name\": \"getRecord\",\n" +
            "        \"outputs\": [\n" +
            "            {\n" +
            "                \"internalType\": \"uint256\",\n" +
            "                \"name\": \"\",\n" +
            "                \"type\": \"uint256\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"string\",\n" +
            "                \"name\": \"\",\n" +
            "                \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"string\",\n" +
            "                \"name\": \"\",\n" +
            "                \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"uint256\",\n" +
            "                \"name\": \"\",\n" +
            "                \"type\": \"uint256\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"uint256\",\n" +
            "                \"name\": \"\",\n" +
            "                \"type\": \"uint256\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"internalType\": \"string\",\n" +
            "                \"name\": \"\",\n" +
            "                \"type\": \"string\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"stateMutability\": \"view\",\n" +
            "        \"type\": \"function\"\n" +
            "    }\n" +
            "]";
    String contractBytecode = "6080604052600060015534801561001557600080fd5b50610a9f806100256000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806303e9e6091461003b57806329a5c3f714610070575b600080fd5b610055600480360381019061005091906103ce565b61008c565b6040516100679695949392919061049a565b60405180910390f35b61008a60048036038101906100859190610645565b6102bf565b005b6000606080600080606060008060008981526020019081526020016000206040518060c0016040529081600082015481526020016001820180546100cf90610743565b80601f01602080910402602001604051908101604052809291908181526020018280546100fb90610743565b80156101485780601f1061011d57610100808354040283529160200191610148565b820191906000526020600020905b81548152906001019060200180831161012b57829003601f168201915b5050505050815260200160028201805461016190610743565b80601f016020809104026020016040519081016040528092919081815260200182805461018d90610743565b80156101da5780601f106101af576101008083540402835291602001916101da565b820191906000526020600020905b8154815290600101906020018083116101bd57829003601f168201915b50505050508152602001600382015481526020016004820154815260200160058201805461020790610743565b80601f016020809104026020016040519081016040528092919081815260200182805461023390610743565b80156102805780601f1061025557610100808354040283529160200191610280565b820191906000526020600020905b81548152906001019060200180831161026357829003601f168201915b5050505050815250509050806000015181602001518260400151836060015184608001518560a001519650965096509650965096505091939550919395565b600160008154809291906102d2906107a3565b91905055506040518060c0016040528060015481526020018681526020018581526020018481526020018381526020018281525060008060015481526020019081526020016000206000820151816000015560208201518160010190816103399190610997565b50604082015181600201908161034f9190610997565b50606082015181600301556080820151816004015560a08201518160050190816103799190610997565b509050505050505050565b6000604051905090565b600080fd5b600080fd5b6000819050919050565b6103ab81610398565b81146103b657600080fd5b50565b6000813590506103c8816103a2565b92915050565b6000602082840312156103e4576103e361038e565b5b60006103f2848285016103b9565b91505092915050565b61040481610398565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610444578082015181840152602081019050610429565b60008484015250505050565b6000601f19601f8301169050919050565b600061046c8261040a565b6104768185610415565b9350610486818560208601610426565b61048f81610450565b840191505092915050565b600060c0820190506104af60008301896103fb565b81810360208301526104c18188610461565b905081810360408301526104d58187610461565b90506104e460608301866103fb565b6104f160808301856103fb565b81810360a08301526105038184610461565b9050979650505050505050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b61055282610450565b810181811067ffffffffffffffff821117156105715761057061051a565b5b80604052505050565b6000610584610384565b90506105908282610549565b919050565b600067ffffffffffffffff8211156105b0576105af61051a565b5b6105b982610450565b9050602081019050919050565b82818337600083830152505050565b60006105e86105e384610595565b61057a565b90508281526020810184848401111561060457610603610515565b5b61060f8482856105c6565b509392505050565b600082601f83011261062c5761062b610510565b5b813561063c8482602086016105d5565b91505092915050565b600080600080600060a086880312156106615761066061038e565b5b600086013567ffffffffffffffff81111561067f5761067e610393565b5b61068b88828901610617565b955050602086013567ffffffffffffffff8111156106ac576106ab610393565b5b6106b888828901610617565b94505060406106c9888289016103b9565b93505060606106da888289016103b9565b925050608086013567ffffffffffffffff8111156106fb576106fa610393565b5b61070788828901610617565b9150509295509295909350565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061075b57607f821691505b60208210810361076e5761076d610714565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006107ae82610398565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82036107e0576107df610774565b5b600182019050919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b60006008830261084d7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610810565b6108578683610810565b95508019841693508086168417925050509392505050565b6000819050919050565b600061089461088f61088a84610398565b61086f565b610398565b9050919050565b6000819050919050565b6108ae83610879565b6108c26108ba8261089b565b84845461081d565b825550505050565b600090565b6108d76108ca565b6108e28184846108a5565b505050565b5b81811015610906576108fb6000826108cf565b6001810190506108e8565b5050565b601f82111561094b5761091c816107eb565b61092584610800565b81016020851015610934578190505b61094861094085610800565b8301826108e7565b50505b505050565b600082821c905092915050565b600061096e60001984600802610950565b1980831691505092915050565b6000610987838361095d565b9150826002028217905092915050565b6109a08261040a565b67ffffffffffffffff8111156109b9576109b861051a565b5b6109c38254610743565b6109ce82828561090a565b600060209050601f831160018114610a0157600084156109ef578287015190505b6109f9858261097b565b865550610a61565b601f198416610a0f866107eb565b60005b82811015610a3757848901518255600182019150602085019450602081019050610a12565b86831015610a545784890151610a50601f89168261095d565b8355505b6001600288020188555050505b50505050505056fea26469706673582212203265f23a051c906e6de1edaa98ac8f4dbac7a1b465c0ead475d77b0a3673450664736f6c63430008120033";

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
      Contract contract = Contract.deployRemoteCall(contractAddress, web3, new Credentials(<votre>), contractGasProvider, contractABI);
      TransactionReceipt transactionReceipt = contract.setRecord("Hello, world!").send();
    } catch (
        IOException ex) {
      throw new RuntimeException("Error whilst sending json-rpc requests", ex);
    }
  }

}
