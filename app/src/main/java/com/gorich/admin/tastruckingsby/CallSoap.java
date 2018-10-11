package com.gorich.admin.tastruckingsby;


import android.os.Build;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by admin on 12/15/2016.
 */

public class CallSoap {
    public final String WSDL_TARGET_NAMESPACE = "http://tastracing.org/";

    //NUSA NET
//    public final String SOAP_ADDRESS = "http://103.238.202.85:99/WebService1.asmx";
    //SPEEDY
//    public final String SOAP_ADDRESS = "http://36.81.248.22:99/WebService1.asmx";
    public final String SOAP_ADDRESS = "http://192.168.2.6:90/WebService1.asmx";

    public final String SOAP_ACTION_LOGIN = "http://tastracing.org/Login";
    public final String SOAP_ACTION_LUPAPASSWORD = "http://tastracing.org/LupaPassword";
    public final String SOAP_ACTION_GANTIPASSWORD= "http://tastracing.org/GantiPassword";
    public final String SOAP_ACTION_GETLIST= "http://tastracing.org/GetListSPMandor";
    public final String SOAP_ACTION_GETLISTABSENSITODAY= "http://tastracing.org/GetListAbsensiTodayMandor";
    public final String SOAP_ACTION_GETCOMBONOPOL= "http://tastracing.org/GetComboNoPol";
    public final String SOAP_ACTION_GETCOMBOEMKL= "http://tastracing.org/GetComboEMKL";
    public final String SOAP_ACTION_GETCOMBOJENISORDERAN= "http://tastracing.org/GetComboJenisOrderan";
    public final String SOAP_ACTION_GETCOMBOTUJUANTARIF= "http://tastracing.org/GetComboTujuanTarif";
    public final String SOAP_ACTION_GETCOMBOUKURANCONT= "http://tastracing.org/GetComboUkuranCont";
    public final String SOAP_ACTION_GETCOMBOSTATUSCONT= "http://tastracing.org/GetComboStatusCont";
    public final String SOAP_ACTION_GETCOMBONOCHASIS= "http://tastracing.org/GetComboNoChasis";
    public final String SOAP_ACTION_GETCOMBOKOTASTD= "http://tastracing.org/GetComboKotaStd";
    public final String SOAP_ACTION_GETCOMBOSHIPPER= "http://tastracing.org/GetComboShipper";
    public final String SOAP_ACTION_GETCOMBOJENISRITASI= "http://tastracing.org/GetComboJenisRitasi";
    public final String SOAP_ACTION_GETCOMBORITASIDR= "http://tastracing.org/GetComboKotaRitasiDr";
    public final String SOAP_ACTION_GETCOMBORITASIKE= "http://tastracing.org/GetComboKotaRitasiKe";
    public final String SOAP_ACTION_GETCOMBOSUPIR= "http://tastracing.org/GetComboSupir";
    public final String SOAP_ACTION_GETCOMBOSTATUSTRADO= "http://tastracing.org/GetComboStatusTrado";
    public final String SOAP_ACTION_ENTRYTRIP= "http://tastracing.org/EntryTripBaru";
    public final String SOAP_ACTION_ENTRYABSENSI= "http://tastracing.org/EntryAbsensiBaru";
    public final String SOAP_ACTION_HAPUSSP= "http://tastracing.org/HapusSP";
    public final String SOAP_ACTION_GETLISTABSENSI= "http://tastracing.org/GetListAbsensi";
    public final String SOAP_ACTION_GETLISTABSENSIDETAIL= "http://tastracing.org/GetListAbsensiDetail";
    public final String SOAP_ACTION_GETNOTIF= "http://tastracing.org/GetNotif";

    public final String SOAP_ACTION_GETCOMBONOPOLONLY= "http://tastracing.org/GetComboNoPolOnly";
    public final String SOAP_ACTION_GETLISTGANTUNG= "http://tastracing.org/GetListSPMandorGantung";
    public final String SOAP_ACTION_ENTRYTRIPGANTUNG= "http://tastracing.org/EntryTripBaruGantung";
    public final String SOAP_ACTION_ENTRYTRIPGANTUNGSENIN= "http://tastracing.org/EntryTripBaruGantungSenin";


    public final String OPERATION_LOGIN = "Login";
    public final String OPERATION_LUPAPASSWORD = "LupaPassword";
    public final String OPERATION_GANTIPASSWORD = "GantiPassword";
    public final String OPERATION_GETLIST = "GetListSPMandor";
    public final String OPERATION_GETLISTABSENSITODAY = "GetListAbsensiTodayMandor";
    public final String OPERATION_GETCOMBONOPOL = "GetComboNoPol";
    public final String OPERATION_GETCOMBOEMKL = "GetComboEMKL";
    public final String OPERATION_GETCOMBOJENISORDERAN= "GetComboJenisOrderan";
    public final String OPERATION_GETCOMBOTUJUANTARIF= "GetComboTujuanTarif";
    public final String OPERATION_GETCOMBOUKURANCONT = "GetComboUkuranCont";
    public final String OPERATION_GETCOMBOSTATUSCONT = "GetComboStatusCont";
    public final String OPERATION_GETCOMBONOCHASIS = "GetComboNoChasis";
    public final String OPERATION_GETCOMBOKOTASTD = "GetComboKotaStd";
    public final String OPERATION_GETCOMBOSHIPPER = "GetComboShipper";
    public final String OPERATION_GETCOMBOJENISRITASI = "GetComboJenisRitasi";
    public final String OPERATION_GETCOMBORITASIDR = "GetComboKotaRitasiDr";
    public final String OPERATION_GETCOMBORITASIKE= "GetComboKotaRitasiKe";
    public final String OPERATION_GETCOMBOSUPIR = "GetComboSupir";
    public final String OPERATION_GETCOMBOSTATUSTRADO= "GetComboStatusTrado";
    public final String OPERATION_ENTRYTRIP = "EntryTripBaru";
    public final String OPERATION_ENTRYABSENSI = "EntryAbsensiBaru";
    public final String OPERATION_HAPUSSP = "HapusSP";
    public final String OPERATION_GETLISTABSENSI  = "GetListAbsensi";
    public final String OPERATION_GETLISTABSENSIDETAIL = "GetListAbsensiDetail";
    public final String OPERATION_GETNOTIF= "GetNotif";

    public final String OPERATION_GETCOMBONOPOLONLY= "GetComboNoPolOnly";
    public final String OPERATION_GETLISTGANTUNG= "GetListSPMandorGantung";
    public final String OPERATION_ENTRYTRIPGANTUNG= "EntryTripBaruGantung";
    public final String OPERATION_ENTRYTRIPGANTUNGSENIN= "EntryTripBaruGantungSenin";

    public String Login(String userid,String password,String device)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_LOGIN);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pPassword");
        pi.setValue(password);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pDevice");
        pi.setValue(device);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_LOGIN, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String LupaPassword(String userid)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_LUPAPASSWORD);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_LUPAPASSWORD , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String HapusSP(String nobukti)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_HAPUSSP);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pNoBukti");
        pi.setValue(nobukti);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_HAPUSSP , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GantiPassword(String userid,String password,String passwordbaru)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GANTIPASSWORD);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pPassword");
        pi.setValue(password);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pPasswordBaru");
        pi.setValue(passwordbaru);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GANTIPASSWORD , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }


    public String EntryTripGantung(String userid, String nopol, String emkl, String jnsorder, String tujuantarif, String dari, String sampai, String ukucont, String nochasis, String statuscont,Integer islongtrip,String shipper,String gudang,String jenisritasi,String ritasidr,String ritasike)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_ENTRYTRIPGANTUNG);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoPol");
        pi.setValue(nopol);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pEMKL");
        pi.setValue(emkl);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJnsOrderan");
        pi.setValue(jnsorder);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pTujuanTarif");
        pi.setValue(tujuantarif);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pDari");
        pi.setValue(dari);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pSampai");
        pi.setValue(sampai);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pCont");
        pi.setValue(ukucont);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoChasis");
        pi.setValue(nochasis);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pStatusCont");
        pi.setValue(statuscont);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pIsLongtrip");
        pi.setValue(islongtrip);
        pi.setType(Integer.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pShipper");
        pi.setValue(shipper);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pGudang");
        pi.setValue(gudang);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJnsRitasi");
        pi.setValue(jenisritasi);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pRitasiDr");
        pi.setValue(ritasidr);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pRitasiKe");
        pi.setValue(ritasike);
        pi.setType(String.class);
        request.addProperty(pi);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_ENTRYTRIPGANTUNG , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String EntryTripGantungSenin(String userid, String nopol, String emkl, String jnsorder, String tujuantarif, String dari, String sampai, String ukucont, String nochasis, String statuscont,Integer islongtrip,String shipper,String gudang,String jenisritasi,String ritasidr,String ritasike)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_ENTRYTRIPGANTUNGSENIN);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoPol");
        pi.setValue(nopol);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pEMKL");
        pi.setValue(emkl);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJnsOrderan");
        pi.setValue(jnsorder);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pTujuanTarif");
        pi.setValue(tujuantarif);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pDari");
        pi.setValue(dari);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pSampai");
        pi.setValue(sampai);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pCont");
        pi.setValue(ukucont);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoChasis");
        pi.setValue(nochasis);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pStatusCont");
        pi.setValue(statuscont);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pIsLongtrip");
        pi.setValue(islongtrip);
        pi.setType(Integer.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pShipper");
        pi.setValue(shipper);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pGudang");
        pi.setValue(gudang);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJnsRitasi");
        pi.setValue(jenisritasi);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pRitasiDr");
        pi.setValue(ritasidr);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pRitasiKe");
        pi.setValue(ritasike);
        pi.setType(String.class);
        request.addProperty(pi);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_ENTRYTRIPGANTUNGSENIN , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetListGantung()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETLISTGANTUNG);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETLISTGANTUNG, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboNoPolOnly(String userid)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBONOPOLONLY);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBONOPOLONLY, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String EntryTrip(String userid, String nopol, String emkl, String jnsorder, String tujuantarif, String dari, String sampai, String ukucont, String nochasis, String statuscont,Integer islongtrip,String shipper,String gudang,String jenisritasi,String ritasidr,String ritasike)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_ENTRYTRIP);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoPol");
        pi.setValue(nopol);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pEMKL");
        pi.setValue(emkl);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJnsOrderan");
        pi.setValue(jnsorder);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pTujuanTarif");
        pi.setValue(tujuantarif);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pDari");
        pi.setValue(dari);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pSampai");
        pi.setValue(sampai);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pCont");
        pi.setValue(ukucont);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoChasis");
        pi.setValue(nochasis);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pStatusCont");
        pi.setValue(statuscont);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pIsLongtrip");
        pi.setValue(islongtrip);
        pi.setType(Integer.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pShipper");
        pi.setValue(shipper);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pGudang");
        pi.setValue(gudang);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJnsRitasi");
        pi.setValue(jenisritasi);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pRitasiDr");
        pi.setValue(ritasidr);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pRitasiKe");
        pi.setValue(ritasike);
        pi.setType(String.class);
        request.addProperty(pi);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_ENTRYTRIP , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String EntryAbsensi(String userid, String nopol, String supir, String status, String ket,String jam)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_ENTRYABSENSI);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pNoPol");
        pi.setValue(nopol);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pSupir");
        pi.setValue(supir);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pStatus");
        pi.setValue(status);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pKet");
        pi.setValue(ket);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("pJam");
        pi.setValue(jam);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_ENTRYABSENSI , envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String GetList()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETLIST);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETLIST, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String GetListAbsensiToday()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETLISTABSENSITODAY);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETLISTABSENSITODAY, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String GetListAbsensi()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETLISTABSENSI);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETLISTABSENSI, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetListAbsensiDetail(String nobukti)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETLISTABSENSIDETAIL);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pNoBukti");
        pi.setValue(nobukti);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETLISTABSENSIDETAIL, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String GetComboJenisRitasi()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOJENISRITASI);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOJENISRITASI, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboRitasiDr()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBORITASIDR);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBORITASIDR, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboRitasiKe()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBORITASIKE);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBORITASIKE, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String GetComboSupir()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOSUPIR);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOSUPIR, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboStatusTrado()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOSTATUSTRADO);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOSTATUSTRADO, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }

    public String GetComboNoPol(String userid)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBONOPOL);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pUser");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBONOPOL, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboEMKL()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOEMKL);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOEMKL, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboJenisOrderan()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOJENISORDERAN);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOJENISORDERAN, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboTujuanTarif()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOTUJUANTARIF);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOTUJUANTARIF, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboUkuranCont()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOUKURANCONT);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOUKURANCONT, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboNoChasis()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBONOCHASIS);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBONOCHASIS, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboKotaStd()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOKOTASTD);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOKOTASTD, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboShipper()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOSHIPPER);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOSHIPPER, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }
    public String GetComboStatusCont()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETCOMBOSTATUSCONT);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETCOMBOSTATUSCONT, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response=exception.toString() + " - KONEKSI KE SERVER TIDAK DAPAT DILAKUKAN";
        }
        return response.toString();
    }


    public String GetNotif(String device)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_GETNOTIF);

        PropertyInfo pi=new PropertyInfo();
        pi.setName("pDevice");
        pi.setValue(device);
        pi.setType(String.class);
        request.addProperty(pi);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        try
        {
            httpTransport.call(SOAP_ACTION_GETNOTIF, envelope);
            response = envelope.getResponse();
        }

        catch (Exception exception)

        {
            response="blank";
        }
        return response.toString();
    }
}