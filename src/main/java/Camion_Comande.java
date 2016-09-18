/**
 * Created by Wéry Lionel on 01/09/2016.
 */
public class Camion_Comande {


    /**
     *i= ligne de commande
     *
     *if (i>0)
     * on regarde le nombre de palette, on calcule la surface total, et le poid totat.
     * On regarde si commande urgente si oui on regarde pour un camion de type B
     *                              ---- si il y en a un de disponible on regarde:
     *                              ---------si il y a la surface disponible et le poids en charge disponible     *
     *                              ----Si oui on charge et on passe la commande en chargée
     *                                        on repasse toute les commande en disponible
     *                                          si le seuil est atteind on peut envoyer le camion.
     *                              et on augmente les palettes du nombre de palette du camion
     *                              ---sinon on regarde dans les camions de type A si il y en a un de disponible<
     *                              ---------si il y a la surface disponible et le poids en charge disponible
     *                                       ----Si oui on charge et on passe la commande en chargée
     *                                        on repasse toute les commande en disponible
     *                              si le seuil est atteind on peut envoyer le camion.
     *                              et on augmente les palettes du nombre de palette du camion
     *
     *          et on remet le nombre de palette dans le camion a zéro.
     *                              sinon on met la commande en attente et on passe à la suivante
     *
     *  Si il y a des comandes autre que urgente;                            *
     * * on regarde si il y a un camion de Type A disponible pour acceuillr la commande
     * pour ça: on regarde si la surface disponible est plus grand ou = à la surface de la commande
     *          on regarde si le poids disponible est plus grand ou = au poids de la commande.
     *          Si oui  on diminue le poids disponible  et la surface disponible du camion$
     *          on stock le nombre de palette (augmente si plusieurs commande)
     *
     *          si le seuil est atteint on peut envoyer le camion. et on augmente les palettes du nombre
     *          de palette du camion
     *          et on remet le nombre de palette dans le camion a zéro.
     *
     *          on passe les commandes en attente en commande en disponible.
     *
     *          i-1 reboucle.
     *   Sinon on met la commande en attente   et on passe à la commande suivante.
     *
     *
     *
     *
     *
    */




}
