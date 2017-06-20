package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.domain.RegistryCarSold;
import com.dh.demo.domain.Seller;
import com.dh.demo.repository.BuyerRepository;
import com.dh.demo.repository.RegistryCarSoldRepository;
import com.dh.demo.repository.SellerRepository;
import com.dh.demo.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ElmerVL on 19/06/2017.
 */
@Service
public class RegistryCarSoldService {

    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerService sellerService;

    public List<RegistryCarSold> getAllRegistryCarSolds(){
        return registryCarSoldRepository.findAll();
    }

    public void addRegistryCarSold(RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldDTO) {
        Buyer buyer = buyerRepository.findOne(registryCarSoldDTO.getBuyerId());

        Seller seller = sellerRepository.findOne(registryCarSoldDTO.getSellerId());
        seller.setNumberCarsSold(seller.getNumberCarsSold()+1);

        RegistryCarSold registryCarSold = new RegistryCarSold();
        registryCarSold.setBuyer(buyer);
        registryCarSold.setSeller(seller);

        registryCarSoldRepository.save(registryCarSold);
    }

    public void updateRegistryCarSold(Long id, RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldDTO) {
        Buyer buyer = buyerRepository.findOne(registryCarSoldDTO.getBuyerId());

        Seller seller = sellerRepository.findOne(registryCarSoldDTO.getSellerId());

        RegistryCarSold registryCarSold = registryCarSoldRepository.findOne(id);
        if (null != registryCarSoldDTO.getBuyerId()) {registryCarSold.setBuyer(buyer);}
        if (null != registryCarSoldDTO.getSellerId()) {registryCarSold.setSeller(seller);}

        registryCarSoldRepository.save(registryCarSold);
    }

    public void deleteRegistryCarSold(Long id) {
        registryCarSoldRepository.delete(id);
    }

    public Seller getSeller(Long id) {
        return sellerRepository.findOne(id);
    }
}
