package com.sap.xi.basis.alerting.api2;

/**
 * Exception class for service fault.
 */
@javax.xml.ws.WebFault(name = "StandardMessageFault", targetNamespace = "http://sap.com/xi/BASIS/Global", faultBean = "com.sap.xi.basis.global.StandardMessageFault")
public class P2StandardMessageFault extends java.lang.Exception {

  private com.sap.xi.basis.global.StandardMessageFault _P2StandardMessageFault;

  public P2StandardMessageFault(String message, com.sap.xi.basis.global.StandardMessageFault faultInfo){
    super(message);
    this._P2StandardMessageFault = faultInfo;
  }

  public P2StandardMessageFault(String message, com.sap.xi.basis.global.StandardMessageFault faultInfo, Throwable cause){
    super(message, cause);
    this._P2StandardMessageFault = faultInfo;
  }

  public com.sap.xi.basis.global.StandardMessageFault getFaultInfo(){
    return this._P2StandardMessageFault;
  }

}
