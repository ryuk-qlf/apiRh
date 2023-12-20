package fr.facil.facilapi.controller;

import fr.facil.facilapi.supplement.UserPhoto;
import fr.facil.facilapi.utils.ApacheFtp;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;

@RestController
@RequestMapping("/uploadFtp")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserPhotoRestController {
    @PutMapping(value="/")
    public void send(@RequestBody UserPhoto[] userPhotoFtp){

        ApacheFtp ftp = new ApacheFtp("80.11.12.120", "RhFacil", "Facil2023");
        try {


            ftp.setConection();

            for (UserPhoto userPhoto : userPhotoFtp) {
                File file = new File("/home/facil/ftp/api/file/" + userPhoto.getNom() + "." + userPhoto.getType());


                try (FileOutputStream fos = new FileOutputStream(file);) {


                    byte[] decoder = Base64.getDecoder().decode(userPhoto.getContent());

                    fos.write(decoder);

                    InputStream inputStream = Files.newInputStream(file.toPath());

                    if (ApacheFtp.getClient().makeDirectory(userPhoto.getPath())) {
                        ApacheFtp.getClient().storeFile(userPhoto.getPath() + "/" + userPhoto.getNom() + "." + userPhoto.getType(), inputStream);
                    }


                    file.delete();


                /*yousignService.updateYousignDocument(y.getId());


                Calendar v_CalendarNow = Calendar.getInstance();
                Date v_dateMonthNow = v_CalendarNow.getTime();
                Date v_dateMonthWithEcheance = v_CalendarNow.getTime();

                int month = (int) (v_CalendarNow.get(Calendar.DATE)+affaire.getClient().getDayOfReglement());

                v_dateMonthWithEcheance.setDate(month);

                String dateNow = new SimpleDateFormat("dd/MM/yyyy").format(v_dateMonthNow);
                String dateNowWithEcheance = new SimpleDateFormat("dd/MM/yyyy").format(v_dateMonthWithEcheance);
                String Now = new SimpleDateFormat("yyyyMMdd").format(v_dateMonthNow);


                facture f = new facture( v_lastNumFacture+ "", dateNow, dateNowWithEcheance, affaire.getClient().getName().replace('_', ' '), "Service Comptabilité", affaire.getClient().getAddress(), affaire.getClient().getZip_code() + ", " + affaire.getClient().getCity(), "7", "8", "9", affaire);
                f.create(v_lastNumFacture, v_lastNumFacture, bl);

                File fileFacture = new File("C:\\Temp\\"+"Facture_"+v_lastNumFacture+"_"+Now+"_"+affaire.getClient().getName()+".pdf");
                //String firstLocalFile = "C:\\Temp\\Facture_3_20220905_Akka_ip.pdf";


                String firstRemoteFile3 = "Affaires/"+affaire.getReference()+"/Factures/Facture_"+v_lastNumFacture+"_"+Now+"_"+affaire.getClient().getName()+".pdf";
*/

                    //InputStream inputStream2 = new FileInputStream(fileFacture);

                    //Ftp.getClient().storeFile(firstRemoteFile3, inputStream2);


                    //inputStream2.close();

                    inputStream.close();
                    ApacheFtp.setDisconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            }catch(Exception ignored){
                ignored.printStackTrace();
            }






    }
}
