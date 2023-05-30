package service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class MySmartContract extends Contract {
    public static final String BINARY = "6080604052600060015534801561001557600080fd5b50610711806100256000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806303e9e6091461003b57806329a5c3f714610069575b600080fd5b61004e610049366004610375565b61008a565b604051610060969594939291906103d4565b60405180910390f35b61007c6100773660046104cf565b6102ba565b604051908152602001610060565b6000606080600080606060008060008981526020019081526020016000206040518060c0016040529081600082015481526020016001820180546100cd9061056b565b80601f01602080910402602001604051908101604052809291908181526020018280546100f99061056b565b80156101465780601f1061011b57610100808354040283529160200191610146565b820191906000526020600020905b81548152906001019060200180831161012957829003601f168201915b5050505050815260200160028201805461015f9061056b565b80601f016020809104026020016040519081016040528092919081815260200182805461018b9061056b565b80156101d85780601f106101ad576101008083540402835291602001916101d8565b820191906000526020600020905b8154815290600101906020018083116101bb57829003601f168201915b5050505050815260200160038201548152602001600482015481526020016005820180546102059061056b565b80601f01602080910402602001604051908101604052809291908181526020018280546102319061056b565b801561027e5780601f106102535761010080835404028352916020019161027e565b820191906000526020600020905b81548152906001019060200180831161026157829003601f168201915b5050509190925250508151602083015160408401516060850151608086015160a090960151939e929d50909b5099509297509550909350505050565b60018054600091826102cb836105a5565b90915550506040805160c0810182526001805480835260208084018b81528486018b9052606085018a90526080850189905260a0850188905260009283529082905293902082518155925191929190820190610327908261061b565b506040820151600282019061033c908261061b565b50606082015160038201556080820151600482015560a08201516005820190610365908261061b565b5050600154979650505050505050565b60006020828403121561038757600080fd5b5035919050565b6000815180845260005b818110156103b457602081850181015186830182015201610398565b506000602082860101526020601f19601f83011685010191505092915050565b86815260c0602082015260006103ed60c083018861038e565b82810360408401526103ff818861038e565b905085606084015284608084015282810360a084015261041f818561038e565b9998505050505050505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261045357600080fd5b813567ffffffffffffffff8082111561046e5761046e61042c565b604051601f8301601f19908116603f011681019082821181831017156104965761049661042c565b816040528381528660208588010111156104af57600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080600060a086880312156104e757600080fd5b853567ffffffffffffffff808211156104ff57600080fd5b61050b89838a01610442565b9650602088013591508082111561052157600080fd5b61052d89838a01610442565b95506040880135945060608801359350608088013591508082111561055157600080fd5b5061055e88828901610442565b9150509295509295909350565b600181811c9082168061057f57607f821691505b60208210810361059f57634e487b7160e01b600052602260045260246000fd5b50919050565b6000600182016105c557634e487b7160e01b600052601160045260246000fd5b5060010190565b601f82111561061657600081815260208120601f850160051c810160208610156105f35750805b601f850160051c820191505b81811015610612578281556001016105ff565b5050505b505050565b815167ffffffffffffffff8111156106355761063561042c565b61064981610643845461056b565b846105cc565b602080601f83116001811461067e57600084156106665750858301515b600019600386901b1c1916600185901b178555610612565b600085815260208120601f198616915b828110156106ad5788860151825594840194600190910190840161068e565b50858210156106cb5787850151600019600388901b60f8161c191681555b5050505050600190811b0190555056fea26469706673582212206ea0b6e109fee6bb43650c1072f64d6b013429e68443edf75cdb12eca985dddb64736f6c63430008130033";

    public static final String FUNC_GETRECORD = "getRecord";

    public static final String FUNC_SETRECORD = "setRecord";

    @Deprecated
    protected MySmartContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MySmartContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MySmartContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MySmartContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, String>> getRecord(BigInteger _id) {
        final Function function = new Function(FUNC_GETRECORD, 
                Arrays.<Type>asList(new Uint256(_id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, String>>(function,
                new Callable<Tuple6<BigInteger, String, String, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple6<BigInteger, String, String, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, String, String, BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> setRecord(String _date, String _signature, BigInteger _minuteNum, BigInteger _minutaireNum, String _designation) {
        final Function function = new Function(
                FUNC_SETRECORD, 
                Arrays.<Type>asList(new Utf8String(_date),
                new Utf8String(_signature),
                new Uint256(_minuteNum),
                new Uint256(_minutaireNum),
                new Utf8String(_designation)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MySmartContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MySmartContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MySmartContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MySmartContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MySmartContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MySmartContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MySmartContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MySmartContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MySmartContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MySmartContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MySmartContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MySmartContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MySmartContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MySmartContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MySmartContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MySmartContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
