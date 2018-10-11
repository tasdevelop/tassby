package com.gorich.admin.tastruckingsby;

/**
 * Created by admin on 12/15/2016.
 */


/**
 * Created by admin on 11/30/2016.
 */

import android.app.AlertDialog;

public class Caller  extends Thread
{

    public AlertDialog ad;
    public CallSoap cs;

    public String sCommand;

    public String user;
    public String password;
    public String device;

    public String passwordbaru;

    public String status;

    //ENTRY TRIP
    public String nopol;
    public String emkl;
    public String jnsorder;
    public String tujuantarif;
    public String dari;
    public String sampai;
    public String ukurancontainer;
    public String nochasis;
    public String statuscont;
    public Integer islongtrip;
    public String shipper;
    public String gudang;
    public String jnsritasi;
    public String ritasidr;
    public String ritasike;
    //ENTRY TRIP

    //ENTRY ABSENSI
    public String supir;
    public String statustrado;
    public String ket;
    public String jam;
    //ENTRY ABSENSI

    //HAPUS TRIP
    public String nobukti;
    //HAPUS TRIP

    public void run()
    {
        try
        {
            cs=new CallSoap();
            if (("login".equals(sCommand)))
            {
                String resp=cs.Login(user,password,device);
                MainActivity.rslt=resp;
            }
            else if (("lupapassword".equals(sCommand)))
            {
                String resp=cs.LupaPassword(user);
                LupaPassword.rslt=resp;
            }
            else if (("gantipassword".equals(sCommand)))
            {
                String resp=cs.GantiPassword(user,password,passwordbaru);
                GantiPassword.rslt=resp;
            }

            else if (("getlist".equals(sCommand)))
            {
                String resp=cs.GetList();
                ListTrip.rslt=resp;
            }
            else if (("getlistabsensitoday".equals(sCommand)))
            {
                String resp=cs.GetListAbsensiToday();
                AbsensiBaru.rslt=resp;
            }
            else if (("getlistabsensi".equals(sCommand)))
            {
                String resp=cs.GetListAbsensi();
                ListAbsensi.rslt=resp;
            }
            else if (("getlistabsensidetail".equals(sCommand)))
            {
                String resp=cs.GetListAbsensiDetail(nobukti);
                ListAbsensiDetail.rslt=resp;
            }
            else if (("getcombonopol".equals(sCommand)))
            {
                String resp=cs.GetComboNoPol(user);
                TripBaru.rslt=resp;
            }
            else if (("getcomboemkl".equals(sCommand)))
            {
                String resp=cs.GetComboEMKL();
                TripBaru.rslt=resp;
            }
            else if (("getcombojenisorderan".equals(sCommand)))
            {
                String resp=cs.GetComboJenisOrderan();
                TripBaru.rslt=resp;
            }
            else if (("getcombotujuantarif".equals(sCommand)))
            {
                String resp=cs.GetComboTujuanTarif();
                TripBaru.rslt=resp;
            }
            else if (("getcomboukurancont".equals(sCommand)))
            {
                String resp=cs.GetComboUkuranCont();
                TripBaru.rslt=resp;
            }
            else if (("getcombostatuscont".equals(sCommand)))
            {
                String resp=cs.GetComboStatusCont();
                TripBaru.rslt=resp;
            }
            else if (("getcombonochasis".equals(sCommand)))
            {
                String resp=cs.GetComboNoChasis();
                TripBaru.rslt=resp;
            }
            else if (("getcomboshipper".equals(sCommand)))
            {
                String resp=cs.GetComboShipper();
                TripBaru.rslt=resp;
            }
            else if (("getcombokotastd".equals(sCommand)))
            {
                String resp=cs.GetComboKotaStd();
                TripBaru.rslt=resp;
            }
            else if (("getcombojenisritasi".equals(sCommand)))
            {
                String resp=cs.GetComboJenisRitasi();
                TripBaru.rslt=resp;
            }
            else if (("getcomboritasidr".equals(sCommand)))
            {
                String resp=cs.GetComboRitasiDr();
                TripBaru.rslt=resp;
            }
            else if (("getcomboritasike".equals(sCommand)))
            {
                String resp=cs.GetComboRitasiKe();
                TripBaru.rslt=resp;
            }


            else if (("getcomboemklgantung".equals(sCommand)))
            {
                String resp=cs.GetComboEMKL();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombojenisorderangantung".equals(sCommand)))
            {
                String resp=cs.GetComboJenisOrderan();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombotujuantarifgantung".equals(sCommand)))
            {
                String resp=cs.GetComboTujuanTarif();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcomboukurancontgantung".equals(sCommand)))
            {
                String resp=cs.GetComboUkuranCont();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombostatuscontgantung".equals(sCommand)))
            {
                String resp=cs.GetComboStatusCont();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombonochasisgantung".equals(sCommand)))
            {
                String resp=cs.GetComboNoChasis();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcomboshippergantung".equals(sCommand)))
            {
                String resp=cs.GetComboShipper();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombokotastdgantung".equals(sCommand)))
            {
                String resp=cs.GetComboKotaStd();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombojenisritasigantung".equals(sCommand)))
            {
                String resp=cs.GetComboJenisRitasi();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcomboritasidrgantung".equals(sCommand)))
            {
                String resp=cs.GetComboRitasiDr();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcomboritasikegantung".equals(sCommand)))
            {
                String resp=cs.GetComboRitasiKe();
                TripBaruGantung.rslt=resp;
            }

            else if (("getcomboemklgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboEMKL();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombojenisorderangantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboJenisOrderan();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombotujuantarifgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboTujuanTarif();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcomboukurancontgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboUkuranCont();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombostatuscontgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboStatusCont();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombonochasisgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboNoChasis();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcomboshippergantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboShipper();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombokotastdgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboKotaStd();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombojenisritasigantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboJenisRitasi();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcomboritasidrgantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboRitasiDr();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcomboritasikegantungsenin".equals(sCommand)))
            {
                String resp=cs.GetComboRitasiKe();
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getcombosupirtripsenin".equals(sCommand)))
            {
                String resp=cs.GetComboSupir();
                ActivityTripBaruGantungSenin.rslt=resp;
            }

            else if (("getcombosupir".equals(sCommand)))
            {
                String resp=cs.GetComboSupir();
                AbsensiBaruEntry.rslt=resp;
            }
            else if (("getcombosupirtrip".equals(sCommand)))
            {
                String resp=cs.GetComboSupir();
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombostatustrado".equals(sCommand)))
            {
                String resp=cs.GetComboStatusTrado();
                AbsensiBaruEntry.rslt=resp;
            }

            else if (("hapustrip".equals(sCommand)))
            {
                String resp=cs.HapusSP(nobukti);
                DetailTrip.rslt=resp;
            }
            else if (("hapustripgantung".equals(sCommand)))
            {
                String resp=cs.HapusSP(nobukti);
                DetailTripGantung.rslt=resp;
            }
            else if (("entrytrip".equals(sCommand)))
            {
                String resp=cs.EntryTrip(user,nopol,emkl,jnsorder,tujuantarif,dari,sampai,ukurancontainer,nochasis,statuscont,islongtrip,shipper,gudang,jnsritasi,ritasidr,ritasike);
                TripBaru.rslt=resp;
            }
            else if (("entryabsensi".equals(sCommand)))
            {
                String resp=cs.EntryAbsensi(user,nopol,supir,statustrado,ket,jam);
                AbsensiBaruEntry.rslt=resp;
            }
            else if (("getnotif".equals(sCommand)))
            {
                String resp=cs.GetNotif(device);
                TASService.rslt=resp;
            }

            else if (("getcombonopolonly".equals(sCommand)))
            {
                String resp=cs.GetComboNoPolOnly(user);
                TripBaruGantung.rslt=resp;
            }
            else if (("getcombonopolonlysenin".equals(sCommand)))
            {
                String resp=cs.GetComboNoPolOnly(user);
                ActivityTripBaruGantungSenin.rslt=resp;
            }
            else if (("getlistgantung".equals(sCommand)))
            {
                String resp=cs.GetListGantung();
                ListTripGantung.rslt=resp;
            }
            else if (("entrytripgantung".equals(sCommand)))
            {
                String resp=cs.EntryTripGantung(user,nopol,emkl,jnsorder,tujuantarif,dari,sampai,ukurancontainer,nochasis,statuscont,islongtrip,shipper,gudang,jnsritasi,ritasidr,ritasike);
                TripBaruGantung.rslt=resp;
            }
            else if (("entrytripgantungsenin".equals(sCommand)))
            {
                String resp=cs.EntryTripGantungSenin(user,nopol,emkl,jnsorder,tujuantarif,dari,sampai,ukurancontainer,nochasis,statuscont,islongtrip,shipper,gudang,jnsritasi,ritasidr,ritasike);
                ActivityTripBaruGantungSenin.rslt=resp;
            }
        }catch(Exception ex)
        {
            //ListTracing.rslt=ex.toString();
        }


    }
}
