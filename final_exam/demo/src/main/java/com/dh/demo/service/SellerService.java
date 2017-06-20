package com.dh.demo.service;

import com.dh.demo.domain.RegistryCarSold;
import com.dh.demo.domain.Seller;
import com.dh.demo.repository.SellerRepository;
import com.dh.demo.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ElmerVL on 19/06/2017.
 */
@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO sellerDTO) {
        Seller seller = new Seller();
        seller.setNumberCarsSold(sellerDTO.getNumberCarsSold());
        seller.setCi(sellerDTO.getCi());
        seller.setName(sellerDTO.getName());
        seller.setAge(sellerDTO.getAge());

        sellerRepository.save(seller);
    }

    public void updateSeller(Long id, SellerController.SellerRequestDTO sellerDTO) {

        Seller seller = sellerRepository.findOne(id);
        if (null != sellerDTO.getName()) {seller.setName(sellerDTO.getName());}
        if (null != sellerDTO.getAge()) {seller.setAge(sellerDTO.getAge());}
        if (null != sellerDTO.getCi()) {seller.setCi(sellerDTO.getCi());}
        if (null != sellerDTO.getNumberCarsSold()) {seller.setNumberCarsSold(sellerDTO.getNumberCarsSold());}

        sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {

        List<RegistryCarSold> registryCarSoldList = registryCarSoldService.getAllRegistryCarSolds();

        for (RegistryCarSold registryCarSold : registryCarSoldList) {
            Seller seller = registryCarSold.getSeller();
            if (seller.getId() == id) {
                registryCarSoldService.deleteRegistryCarSold(registryCarSold.getId());
            }
        }

        sellerRepository.delete(id);
    }
}
