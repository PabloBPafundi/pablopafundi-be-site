package com.pablopafundi.site.portfolio;

import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class PortfolioService {

    private final PortfolioMapper portfolioMapper;
    private final PortfolioRepository portfolioRepository;


    public PortfolioService(PortfolioMapper portfolioMapper, PortfolioRepository portfolioRepository) {
        this.portfolioMapper = portfolioMapper;
        this.portfolioRepository = portfolioRepository;
    }

    /*
    public List<PortfolioResponseDTO> getPortfolio(LanguageEnum lang){

        return portfolioRepository.findByIsActiveTrueAndLang(lang)
                .stream()
                .map(portfolioMapper::ToPortfolioResponseDTO)
                .collect(Collectors.toList());
    }*/

    @Async
    public CompletableFuture<List<PortfolioResponseDTO>> getPortfolio(LanguageEnum lang) {
        List<PortfolioResponseDTO> achievements = portfolioRepository.findByIsActiveTrueAndLang(lang)
                .stream()
                .map(portfolioMapper::ToPortfolioResponseDTO)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(achievements);
    }


    public PortfolioResponseDTO savePortfolio(LanguageEnum lang, PortfolioDTO portfolioDTO){
        var portfolio = portfolioMapper.toPortfolio(portfolioDTO);
        portfolio.setLang(lang);
        return portfolioMapper.ToPortfolioResponseDTO(portfolioRepository.save(portfolio));

    }


}
