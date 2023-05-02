package presentation;

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
public class MyContract extends Contract {
    public static final String BINARY = "6080604052600060015534801561001557600080fd5b506106fe806100256000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806303e9e6091461003b57806329a5c3f714610069575b600080fd5b61004e610049366004610362565b61007e565b604051610060969594939291906103c1565b60405180910390f35b61007c6100773660046104bc565b6102ae565b005b6000606080600080606060008060008981526020019081526020016000206040518060c0016040529081600082015481526020016001820180546100c190610558565b80601f01602080910402602001604051908101604052809291908181526020018280546100ed90610558565b801561013a5780601f1061010f5761010080835404028352916020019161013a565b820191906000526020600020905b81548152906001019060200180831161011d57829003601f168201915b5050505050815260200160028201805461015390610558565b80601f016020809104026020016040519081016040528092919081815260200182805461017f90610558565b80156101cc5780601f106101a1576101008083540402835291602001916101cc565b820191906000526020600020905b8154815290600101906020018083116101af57829003601f168201915b5050505050815260200160038201548152602001600482015481526020016005820180546101f990610558565b80601f016020809104026020016040519081016040528092919081815260200182805461022590610558565b80156102725780601f1061024757610100808354040283529160200191610272565b820191906000526020600020905b81548152906001019060200180831161025557829003601f168201915b5050509190925250508151602083015160408401516060850151608086015160a090960151939e929d50909b5099509297509550909350505050565b600180549060006102be83610592565b90915550506040805160c0810182526001805480835260208084018a81528486018a9052606085018990526080850188905260a085018790526000928352908290529390208251815592519192919082019061031a9082610608565b506040820151600282019061032f9082610608565b50606082015160038201556080820151600482015560a082015160058201906103589082610608565b5050505050505050565b60006020828403121561037457600080fd5b5035919050565b6000815180845260005b818110156103a157602081850181015186830182015201610385565b506000602082860101526020601f19601f83011685010191505092915050565b86815260c0602082015260006103da60c083018861037b565b82810360408401526103ec818861037b565b905085606084015284608084015282810360a084015261040c818561037b565b9998505050505050505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261044057600080fd5b813567ffffffffffffffff8082111561045b5761045b610419565b604051601f8301601f19908116603f0116810190828211818310171561048357610483610419565b8160405283815286602085880101111561049c57600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080600060a086880312156104d457600080fd5b853567ffffffffffffffff808211156104ec57600080fd5b6104f889838a0161042f565b9650602088013591508082111561050e57600080fd5b61051a89838a0161042f565b95506040880135945060608801359350608088013591508082111561053e57600080fd5b5061054b8882890161042f565b9150509295509295909350565b600181811c9082168061056c57607f821691505b60208210810361058c57634e487b7160e01b600052602260045260246000fd5b50919050565b6000600182016105b257634e487b7160e01b600052601160045260246000fd5b5060010190565b601f82111561060357600081815260208120601f850160051c810160208610156105e05750805b601f850160051c820191505b818110156105ff578281556001016105ec565b5050505b505050565b815167ffffffffffffffff81111561062257610622610419565b610636816106308454610558565b846105b9565b602080601f83116001811461066b57600084156106535750858301515b600019600386901b1c1916600185901b1785556105ff565b600085815260208120601f198616915b8281101561069a5788860151825594840194600190910190840161067b565b50858210156106b85787850151600019600388901b60f8161c191681555b5050505050600190811b0190555056fea2646970667358221220115e8d25c6d3c419fa1c9fea819cca3cf1a1a07e41f43224bdd0ea2a4d4b799564736f6c63430008130033";

    public static final String FUNC_GETRECORD = "getRecord";

    public static final String FUNC_SETRECORD = "setRecord";

    @Deprecated
    protected MyContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static MyContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MyContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
