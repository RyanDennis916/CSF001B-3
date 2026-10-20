public class Foothill {
    public static void main(String[] args) {
        System.out.println("Base Class Testing ***********************\n");

        InternetUser u1 = new InternetUser();
        System.out.println(u1);

        InternetUser u2 = new InternetUser("dns", "75.75.75.75");
        System.out.println(u2);

        System.out.println("getName(): " + u2.getName());
        System.out.println("getIp(): " + u2.getIp());

        boolean nameOk = u2.setName("x");
        System.out.println("setName(\"x\") (too short) returned: " + nameOk);
        boolean ipOk = u2.setIp("1");
        System.out.println("setIp(\"1\") (too short) returned: " + ipOk);
        System.out.println(u2);

        InternetUser u3 = new InternetUser("www", "8.8.8.8");
        boolean nameOk2 = u3.setName("foothill.edu");
        System.out.println("setName(\"foothill.edu\") returned: " + nameOk2);
        boolean ipOk2 = u3.setIp("153.18.96.219");
        System.out.println("setIp(\"153.18.96.219\") returned: " + ipOk2);
        System.out.println(u3);

        System.out.println("\nDerived Class Constructor Testing ***************\n");

        Communicator c1 = new Communicator();
        System.out.println(c1);

        Communicator c2 = new Communicator("salim lakhani", "10.1.10.1");
        System.out.println(c2);

        Communicator c3 = new Communicator(17, 17);
        System.out.println(c3);

        Communicator c4 = new Communicator("sally", "0.0.0.0", 19, 37);
        System.out.println(c4);

        Communicator c5 = new Communicator("betty", "1.1.1.1", 4, 9);
        System.out.println(c5);

        System.out.println("Derived and Base Class Mutator Testing **********\n");

        Communicator c6 = new Communicator("giral", "0.0.0.0");
        System.out.println(c6);

        boolean primeOk = c6.setPrimes(809, 821);
        System.out.println("setPrimes(809, 821) returned: " + primeOk);
        System.out.println(c6);

        boolean badPrimes = c6.setPrimes(10, 10);
        System.out.println("setPrimes(10, 10) (equal, non-prime) returned: " + badPrimes);

        System.out.println("getPublicKey(): " + c6.getPublicKey());
        System.out.println("getPrivateKey(): " + c6.getPrivateKey());
    }
}

class InternetUser {
    public static final int MAX_NAME_LENGTH = 50;
    private static final int MIN_NAME_LENGTH = 2;
    public static final String DEFAULT_NAME = "default";
    public static final String DEFAULT_IP = "0.0.0.0";
    private static final int MIN_IP_LENGTH = 7;
    private static final int MAX_IP_LENGTH = 15;

    private String name;
    private String ip;

    public InternetUser() {
        this.name = DEFAULT_NAME;
        this.ip = DEFAULT_IP;
    }

    public InternetUser(String name, String ip) {
        if (name == null || ip == null) throw new NullPointerException("name and ip cannot be null");
        this.name = DEFAULT_NAME;
        this.ip = DEFAULT_IP;
        setName(name);
        setIp(ip);
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public boolean setName(String name) {
        if (name == null) throw new NullPointerException("name cannot be null");
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) return false;
        this.name = name;
        return true;
    }

    public boolean setIp(String ip) {
        if (ip == null) throw new NullPointerException("ip cannot be null");
        if (ip.length() < MIN_IP_LENGTH || ip.length() > MAX_IP_LENGTH) {
            return false;
        }
        this.ip = ip;
        return true;
    }

    public String toString() {
        return "InternetUser{name='" + name + "', ip='" + ip + "'}";
    }
}

/**
 * 1 object of this class extends an InternetUser who has private and public encryption keys
 * Constructor and setPrimes make the keys, which can also be gotten using getter functions
 * These keys can also be displayed with users info using the toString method of the class
 *
 * @author Atharv Dua
 * @author Ryan Dennis
 */

class Communicator extends InternetUser
{
    public static final long ERROR_FLAG_NUM = 0;
    private static final long MAX_PQ = (long) Math.sqrt(Long.MAX_VALUE);
    private IntPair publicKey;
    private IntPair privateKey;
    private long firstPrime;
    private long secondPrime;
    private long n;
    private long phi;
    private long e;
    private long d;

    /**
     * Creates a communicator with a default name and ip address and undefined encryption keys
     */
    public Communicator()
    {
        this(DEFAULT_NAME, DEFAULT_IP, ERROR_FLAG_NUM, ERROR_FLAG_NUM);
    }

    /**
     * Creates a communicator with a default name and ip address
     * If invalid primes, then it'll have undefined encryption keys
     *
     * @param firstPrime prime number different from secondPrime
     * @param secondPrime prime number different from firstPrime
     */
    public Communicator(long firstPrime, long secondPrime) {
        this(DEFAULT_NAME, DEFAULT_IP, firstPrime, secondPrime);
    }

    /**
     * Creates a communicator with the passed name and ip address
     * Undefined encryption keys in this one by default
     * If they pass in an invalid name or ip value it's replaced by their default values
     *
     * @param name the communicators name
     * @param ip the communicators ip address
     */
    public Communicator(String name, String ip) {
        this(name, ip, ERROR_FLAG_NUM, ERROR_FLAG_NUM);
    }

    /**
     * Creates a communicator with the passed name, ip address and primes
     * If they pass in an invalid name or ip value it's replaced by their default values
     * If invalid primes, then it'll have undefined encryption keys (0s)
     *
     * @param name the communicators name
     * @param ip the communicators ip address
     * @param firstPrime prime number different from secondPrime
     * @param secondPrime prime number different from firstPrime
     */
    public Communicator(String name, String ip,long firstPrime, long secondPrime) {
        super(name, ip);

        if (!setPrimes(firstPrime, secondPrime))
        {
            this.firstPrime = ERROR_FLAG_NUM;
            this.secondPrime = ERROR_FLAG_NUM;
            n = ERROR_FLAG_NUM;
            phi = ERROR_FLAG_NUM;
            e = ERROR_FLAG_NUM;
            d = ERROR_FLAG_NUM;

            publicKey = new IntPair(ERROR_FLAG_NUM, ERROR_FLAG_NUM);
            privateKey = new IntPair(ERROR_FLAG_NUM, ERROR_FLAG_NUM);
        }
    }

    /**
     * Sets two primes that aren't equal to each other and creates new encryption keys
     * Each prime has to be more than or equal to 2 but not more than the sqrt of
     * Long.MAX_VALUE
     * Invalid arguments won't change the object
     *
     * @param firstPrime prime number 2
     * @param secondPrime prime number 2
     * @return true if primes are valid and keys are created. if not, then false
     */

    public boolean setPrimes(long firstPrime, long secondPrime){
        if (firstPrime<2 || secondPrime<2){
            return false;
        }

        if (firstPrime > MAX_PQ || secondPrime > MAX_PQ) {
            return false;
        }

        if (firstPrime == secondPrime)    {
            return false;
        }

        if (!EncryptionSupport.isPrime(firstPrime)) {
            return false;
        }

        if (!EncryptionSupport.isPrime(secondPrime)) {
            return false;
        }

        this.firstPrime = firstPrime;
        this.secondPrime = secondPrime;

        return computeBothEncrKeys();
    }

    /**
     * Returns a copy of the key that's supposed to be shared with other users
     *
     * @return copy of the public key
     */
    public IntPair getPublicKey() {
        return new IntPair(publicKey.firstInt, publicKey.secondInt);
    }
    /**
     * Returns a copy of the key that's supposed to be kept secret (belongs only to this user)
     *
     * @return copy of the private key
     */
    public IntPair getPrivateKey(){
        return new IntPair(privateKey.firstInt, privateKey.secondInt);
    }

    private boolean computeBothEncrKeys() {
        if (firstPrime<2 || secondPrime<2){
            return false;
        }

        if (firstPrime > MAX_PQ || secondPrime > MAX_PQ) {
            return false;
        }

        if (firstPrime == secondPrime)    {
            return false;
        }

        if (!EncryptionSupport.isPrime(firstPrime)) {
            return false;
        }
        if (!EncryptionSupport.isPrime(secondPrime)) {
            return false;
        }

        n = firstPrime*secondPrime;
        phi = (firstPrime - 1) * (secondPrime - 1);

        boolean found = false;
        int tries = 0;

        while (!found && tries<10000000)
        {
            e = EncryptionSupport.getSmallRandomPrime();

            if (e <phi && phi % e!=0) found = true;

            tries++;
        }

        if (!found) return false;

        d = EncryptionSupport.inverseModN(e, n);

        publicKey = new IntPair(e, n);
        privateKey = new IntPair(d, n);

        return true;
    }

    /**
     * returns this communicator in a string format which is readable for humans
     * this description includes the communicators user info, and encryption data
     *
     * @return a string version of the communicator object
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n(p, q)  n, phi, e, d: (" +
            firstPrime + ", " + secondPrime + ")   " + n +
            ", " + phi + ", " + e + ", " + d + "\npublic key("
            + publicKey.firstInt + ", " + publicKey.secondInt +
            ")" + "\nprivate key(" + privateKey.firstInt + ", "
            + privateKey.secondInt + ")\n";
    }
}

/* 
Foothill.main() run ----------

Base Class Testing --------------

InternetUser{name='default', ip='0.0.0.0'}
InternetUser{name='dns', ip='75.75.75.75'}
getName(): dns
getIp(): 75.75.75.75
setName("x") (too short) returned: false
setIp("1") (too short) returned: false
InternetUser{name='dns', ip='75.75.75.75'}
setName("foothill.edu") returned: true
setIp("153.18.96.219") returned: true
InternetUser{name='foothill.edu', ip='153.18.96.219'}

Derived Class Constructor Testing -----------

InternetUser{name='default', ip='0.0.0.0'}
(p, q)  n, phi, e, d: (0, 0)   0, 0, 0, 0
public key(0, 0)
private key(0, 0)

InternetUser{name='salim lakhani', ip='10.1.10.1'}
(p, q)  n, phi, e, d: (0, 0)   0, 0, 0, 0
public key(0, 0)
private key(0, 0)

InternetUser{name='default', ip='0.0.0.0'}
(p, q)  n, phi, e, d: (0, 0)   0, 0, 0, 0
public key(0, 0)
private key(0, 0)

InternetUser{name='sally', ip='0.0.0.0'}
(p, q)  n, phi, e, d: (19, 37)   703, 648, 439, 466
public key(439, 703)
private key(466, 703)

InternetUser{name='betty', ip='1.1.1.1'}
(p, q)  n, phi, e, d: (0, 0)   0, 0, 0, 0
public key(0, 0)
private key(0, 0)

Derived and Base Class Mutator Testing -----------

InternetUser{name='giral', ip='0.0.0.0'}
(p, q)  n, phi, e, d: (0, 0)   0, 0, 0, 0
public key(0, 0)
private key(0, 0)

setPrimes(809, 821) returned: true
InternetUser{name='giral', ip='0.0.0.0'}
(p, q)  n, phi, e, d: (809, 821)   664189, 662560, 61, 315762
public key(61, 664189)
private key(315762, 664189)

setPrimes(10, 10) (equal, non-prime) returned: false
getPublicKey(): (61, 664189)
getPrivateKey(): (315762, 664189)

JUnit TestSuite run (IntPairTest, InternetUserTest, CommunicatorTest, IntegrationTest) ***

Test run finished after 245 ms
[         5 containers found      ]
[         0 containers skipped    ]
[         5 containers started    ]
[         0 containers aborted    ]
[         5 containers successful ]
[         0 containers failed     ]
[        14 tests found           ]
[         0 tests skipped         ]
[        14 tests started         ]
[         0 tests aborted         ]
[        13 tests successful      ]
[         1 tests failed          ]

*/
