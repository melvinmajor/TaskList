---
subtitle: Projet Java 2ème session 2020 - EPHEC
keywords: [Java, app, tâches, task, todo, list, liste, dev, cahier de charges, specifications, EPHEC]
header-left: TaskList - Projet Java 2ème session 2020 - EPHEC
footer-left: Cahier de charges
toc: true
toc-own-page: true
toc-title: TaskList - Cahier de charges
---

ActA représenté : _**Pratique**_

Repository GitHub : <https://github.com/melvinmajor/TaskList>

# Le projet

Ce projet est une forme de liste de tâches.
L'intérêt ici est de pouvoir l'utiliser quotidiennement pour diverses tâches provenant de divers domaines : les cours, les projets personnels/professionnels, etc.

Comme requis, ce programme fonctionnera sous l'architecture MVC (Model-View-Controller).
Une interface en ligne de commandes est prévue et est l'interface principale.
Une interface graphique sera également développée (sous Swing ou JavaFX).

Le langage de programmation Java est utilisé et d'après les prérequis, sa version 12 est la version recommandée.
Étant donné qu'il s'agit d'une version non "LTS" (Long-Term-Support) et le support de Java SE 12 étant arrêté depuis septembre 2019, le Java Development Kit (JDK) utilisé pour le développement du projet sera sous la version 14 dont le support est maintenu jusqu'en septembre 2020.

Plus d'information sur le support des versions de Java à l'adresse suivante : <https://www.oracle.com/java/technologies/java-se-support-roadmap.html>.

## But du projet

Proposer une application simple d'utilisation permettant de créer une nouvelle tâche ainsi que de la supprimer lorsque terminée ou nécessaire.
En d'autres termes, les tâches entrées doivent être stockées et l'utilisateur doit pouvoir y accéder ainsi que de les gérer.

## Besoins fonctionnels

* En tant qu'utilisateur, je veux... :
  * Ajouter une tâche en indiquant une description quelconque,
  * Voir toutes les tâches enregistré **afin de** parcourir toutes mes tâches en cours,
  * Supprimer une tâche de façon rapide **afin de** supprimer les tâches terminées,
  * Avoir une aide dans l'interface console **afin de** connaître toutes les commandes disponible et ce qu'elles font,
  * Disposer d'une interface graphique simple et intuitive.

_Quelques idées d'implémentations futures / pistes d'amélioration intéressantes :_

* En tant qu'utilisateur, je veux... :
  * Eventuellement enregistrer une date butoir pour ma tâche **afin de** mieux gérer les priorités,
  * Voir toutes les tâches triées en fonction de la date butoir (celles sans date seraient en tête de liste).

## Contraintes

L'application Java doit répondre à certaines exigences générales :

* Exploite de manière adéquate les concepts orientés-objet,
* Présente une interface graphique,
* Respecte l’architecture MVC,
* Comporte au moins une Collection ou une Map utilisée à bon escient,
* Comporte au moins un héritage utilisé à bon escient,
* Comporte au moins une interface utilisée à bon escient.

De plus, il devra répondre à quelques exigences propre au projet :

* Le stockage des tâches est nécessaire pour permettre à l'utilisateur de retrouver ces tâches après avoir quitté l'application,
* Un système d'ID doit être implémenté afin de faciliter la suppression d'une tâche.
