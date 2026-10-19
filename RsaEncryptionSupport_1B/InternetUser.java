/**
 * Represents a user identified by a name and an IP address.
 */
public class InternetUser {
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MIN_NAME_LENGTH = 2;
    private static final String DEFAULT_NAME = "default";
    private static final String DEFAULT_IP = "0.0.0.0";
    private static final int MIN_IP_LENGTH = 7;
    private static final int MAX_IP_LENGTH = 15;

    private String name;
    private String ip;

    /**
     * Creates an InternetUser with the default name and IP address.
     */
    public InternetUser() {
        this.name = DEFAULT_NAME;
        this.ip = DEFAULT_IP;
    }

    /**
     * Creates an InternetUser with the given name and IP address.
     *
     * @param name the user's name
     * @param ip the user's IP address
     * @throws NullPointerException if name or ip is null
     */
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
