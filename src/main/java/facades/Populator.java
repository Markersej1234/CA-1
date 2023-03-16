/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dtos.CityInfoDTO;
import dtos.PersonDTO;
import entities.Person;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;
import utils.HttpUtils;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade fe = PersonFacade.getFacadeExample(emf);

//        fe.createPerson(new PersonDTO(new Person("Bob", "Lars","Bob123@gmail.com")));

        String json = HttpUtils.fetchAPIData("https://api.dataforsyningen.dk/postnumre");
        Type collectionType = new TypeToken<Collection<CityInfoDTO>>(){}.getType();
        Collection<CityInfoDTO> ZipDTO = gson.fromJson(json, collectionType);

        for (CityInfoDTO dto : ZipDTO) {
            fe.insertCityInfo(new CityInfoDTO(dto.getZipCode(), dto.getCity()));
        }
    }

    public static void main(String[] args) {
        populate();
    }
}
