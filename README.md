# Le livre de Walidou 

## Vocabulaire
- Partie : encapsule une histoire et son état
- Histoire : ensemble de pages
- Page : une image, un texte et des choix
- Choix : un choix influence la suite de l'histoire donc les prochaines pages
- Inventaire : ensemble des "objets" détenus par le joueur

## Description de l'application

### Quoi ?
Le livre de Walidou est un [livre dont vous êtes le héros](https://fr.wikipedia.org/wiki/Un_livre_dont_vous_%C3%AAtes_le_h%C3%A9ros) sous la forme d'une application Android.

### Interface
Pour chaque page de l'histoire, une image et un texte est présenté au joueur. En dessous, les choix possibles en rapport avec l'image et le texte.

### Comportement de l'application
- Le joueur a le choix de charger une partie sauvegardée ou d'en commencer une nouvelle
- Une partie a un scénario qui est une histoire
- Entre 2 et 3 choix sont possibles
- Les choix soumis influencent la suite de l'histoire
- Des choix permettent de remplir ou d'utiliser l'inventaire du joueur
- Les objets de l'inventaire peuvent débloquer des choix sur une page de l'histoire
- L'avancée de l'histoire est sauvegardée dans la partie automatiquement à chaque page 



## Maquette
[Lien vers la maquette](https://www.figma.com/file/1NebmQL2UvMmTIscu0DbeE/Projet-Android?node-id=0%3A1)


## Scénario type d'utilisation
1. Le joueur charge une nouvelle histoire
2. La première page de l'histoire est présentée, plusieurs choix sont présentés
3. Après sélection d'un choix, une nouvelle page de l'histoire est présentée au joueur
