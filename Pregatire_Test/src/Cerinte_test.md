# Cerințe

## Cerința 1

Să se definească o interfață `Cumparabil` care conține metoda:

- `float getPret();`

Și o clasă abstractă `BiletAbstract` care:

- implementează interfața `Cumparabil`;
- conține atributele:
  - `plecare` (`String`);
  - `sosire` (`String`);
  - `distanta` (`int`);
- are constructor cu parametri pentru inițializare.

## Cerința 2

În clasa `BiletAbstract`:

- să se implementeze metoda `getPret()` (valoare fixă, ex: `3`);
- să se definească o metodă abstractă:
  - `float getReducere();`

## Cerința 3

Să se definească:

- un `enum TipReducere` cu valori:
  - `STUDENT`;
  - `PENSIONAR`.

Să se creeze clasa `BiletAutocar` care:

- moștenește `BiletAbstract`;
- conține atributul:
  - `tipReducere` (`TipReducere`).

## Cerința 4

În clasa `BiletAutocar`:

- să se implementeze metoda `getReducere()` astfel:
  - `STUDENT` -> `50%`;
  - `PENSIONAR` -> `90%`;
- să se adauge un atribut:
  - `statii` (vector de `String`);
- să se creeze getter și setter pentru acesta.

## Cerința 5

În clasa `BiletAutocar`:

- să se implementeze:
  - getteri pentru toate atributele;
  - metoda `clone()` (deep copy pentru vector);
- să se suprascrie metoda `getPret()` astfel:
  - `pret = pretDeBaza * distanta * (1 - reducere)`.

## Cerința 6

Să se suprascrie metoda `toString()`:

- format:
  - `-- plecare sosire distanta --`

## Cerința 7

În clasa `BiletAutocar`:

- să se definească o colecție statică;
- să se implementeze metode:
  - `emiteBilet()` -> adaugă bilet în listă;
  - `bileteEmise()` -> returnează colecția.

## Cerința 8

Să se creeze o clasă `Utils` cu o metodă:

- care primește:
  - o listă de bilete;
  - o valoare;
- returnează un `Stream` filtrat astfel:
  - doar bilete cu reducere `STUDENT`;
  - `distanta < valoare`.

## Cerința 9

În clasa `Utils`:

- să se implementeze o metodă care:
  - primește un obiect `BiletAutocar`;
  - salvează datele acestuia într-un fișier text.
