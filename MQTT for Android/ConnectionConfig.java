package com.zhangkong.letsgo.im.core.config;

/**
 * MQTT 服务器连接配置
 * Created by w on 2016/3/8.
 */
public class ConnectionConfig {
    // 服务器地址
    private String serverAddr = "192.168.10.165";
    // 客户端ID
    private String clientId = "";
    // 服务器端口
    private int port = ActivityConstants.defaultPort;
    // 是否清楚 SESSION
    private boolean cleanSession = false;
    // 是否启用SSL
    private boolean isSSL = ActivityConstants.defaultSsl;
    // SSL key 文件保存路径
    private String sslKey = "";
    // 登录成功后发送的消息
    private String message = "";
    // 登录成功后关注的主题
    private String topic = "";
    // 登录成功后发送消息的QOS
    private int qos = ActivityConstants.defaultQos;
    // 登录成功后发送消息的Retained(是否保留)
    private boolean retained = ActivityConstants.defaultRetained;
    // 登录用户名
    private String username = "";
    //登录密码
    private String password = "";
    // 登录超时时间
    private int timeout = 60;
    private int keepalive = ActivityConstants.defaultKeepAlive;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isCleanSession() {
        return cleanSession;
    }

    public void setCleanSession(boolean cleanSession) {
        this.cleanSession = cleanSession;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setIsSSL(boolean isSSL) {
        this.isSSL = isSSL;
    }

    public String getSslKey() {
        return sslKey;
    }

    public void setSslKey(String sslKey) {
        this.sslKey = sslKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public boolean isRetained() {
        return retained;
    }

    public void setRetained(boolean retained) {
        this.retained = retained;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(int keepalive) {
        this.keepalive = keepalive;
    }
}
