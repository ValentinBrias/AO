/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import packageEntites.CarteAPuce;
import packageEntites.Client;
import packageEntites.CompteBancaire;
import packageEntites.Personne;
import packageFacades.AbonnementFacadeLocal;
import packageFacades.CarteAPuceFacadeLocal;
import packageFacades.ClientFacadeLocal;
import packageFacades.CompteBancaireFacadeLocal;
import packageFacades.PorteMonnaieElecFacadeLocal;

/**
 *
 * @author 3092790
 */
@Stateless
public class SessionCommercial implements SessionCommercialLocal {
    @EJB
    private PorteMonnaieElecFacadeLocal porteMonnaieElecFacade;
    @EJB
    private AbonnementFacadeLocal abonnementFacade;
    @EJB
    private CarteAPuceFacadeLocal carteAPuceFacade;
    @EJB
    private CompteBancaireFacadeLocal compteBancaireFacade;
    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    public Client CreerClient(String num, String mdp, String nom, String prenom, CarteAPuce carte) {
        Client c = clientFacade.CreerClient(num, mdp, nom, prenom, carte);
        return c;
    }

    @Override
    public List<Client> RetournerClients() {
        return clientFacade.RetournerClients();
    }

    @Override
    public List<CompteBancaire> RetournerComptes() {
        return compteBancaireFacade.RetournerComptes();
    }

    @Override
    public void CreerCompte(int num, String titulaire, String banque, int guichet, Client client) {
        compteBancaireFacade.CreerCompte(num, titulaire, banque, guichet, client);
    }

    @Override
    public CarteAPuce CreerCarteAPuce(Date datedebut, Date datefin) {
        CarteAPuce c = carteAPuceFacade.CreerCarteAPuce(datedebut, datefin);
        return c;
    }

    @Override
    public Client RechercherClientParId(long id) {
        return clientFacade.RechercherClientParId(id);
    }

    @Override
    public void ModifierClient(Long id, String num, String nom, String prenom) {
        clientFacade.ModifierClient(id, num, nom, prenom);
    }

    @Override
    public CompteBancaire RechercherCompteParId(long id) {
        return compteBancaireFacade.RechercherCompteParId(id);
    }

    @Override
    public void ModifierCompte(long id, int num, String titulaire, String banque, int guichet) {
        compteBancaireFacade.ModifierCompte(id, num, titulaire, banque, guichet);
    }

    @Override
    public void CreerAbonnement(String num, String type, Double montant, CarteAPuce carte) {
        abonnementFacade.CreerAbonnement(num, type, montant, carte);
    }

    @Override
    public void CreerPorteMonnaieElectronique(CarteAPuce carte) {
        porteMonnaieElecFacade.CreerPorteMonnaieElec(carte);
    }
}
