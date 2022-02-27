package com.kamnetanker;



public class GameStarter {
    // ==== data part ====
    private Game _gamePerformer;
    private Athlet[] _athletesArray;
    private IDiscipline[] _gameDisciplines;
    // ==== data part end ====

    // ==== getters/setters part ====
    public Game get_gamePerformer() {
        return _gamePerformer;
    }

    public void set_gamePerformer(Game _gamePerformer) {
        this._gamePerformer = _gamePerformer;
    }

    public Athlet[] get_athletesArray() {
        return _athletesArray;
    }

    public void set_athletesArray(Athlet[] _athletesArray) {
        this._athletesArray = _athletesArray;
    }

    public IDiscipline[] get_gameDisciplines() {
        return _gameDisciplines;
    }

    public void set_gameDisciplines(IDiscipline[] _gameDisciplines) {
        this._gameDisciplines = _gameDisciplines;
    }
    // ==== getters/setters part end ====

    // ==== constructors ====

    // ==== constructors end ====

    // ==== common funcs ====

    private void PrepareAthletes(int _athletesCount){
        System.out.println("==================");
        System.out.println("Athletes registration begins!");
        System.out.println("==================");
        this.set_athletesArray(new Athlet[_athletesCount]);

        for(int i=0; i<_athletesCount; i++){
            this.get_athletesArray()[i]=new Athlet(i);// sending i as athlet id
            System.out.printf("Athlet with number %d registered!\n", i);
        }
        System.out.println("==================");
        System.out.println("Athletes registration ended!");
        System.out.println("==================");
    }

    private void PrepareDisciplines(EDisciplines[] _disciplinesOrder) {
        System.out.println("==================");
        System.out.println("Organists are preparing disciplines order!");
        System.out.println("==================");
        this.set_gameDisciplines(new IDiscipline[_disciplinesOrder.length]);

        for(int i=0; i<_disciplinesOrder.length; i++){
            switch (_disciplinesOrder[i]) {
                case run -> {
                    System.out.printf("Discipline %d will be run!", i);
                    this.get_gameDisciplines()[i] = new RunDiscipline();
                }
                case jump -> {
                    System.out.printf("Discipline %d will be jump!", i);
                    this.get_gameDisciplines()[i] = new JumpDiscipline();
                }
                case pushups -> {
                    System.out.printf("Discipline %d will be pushups!", i);
                    this.get_gameDisciplines()[i] = new PushUpsDiscipline();
                }
            }
        }
        System.out.println("==================");
        System.out.println("Organists have prepared disciplines order!");
        System.out.println("==================");
    }

    private void PrepareGame(){
        System.out.println("==================");
        System.out.println("Final preparation!");
        System.out.println("==================");
        this.set_gamePerformer(new Game(get_gameDisciplines(), get_athletesArray()));
        System.out.println("==================");
        System.out.println("All is done!");
        System.out.println("==================");
    }

    private void SortAthletesResult(){
        int i,k, rightBorder;
        int size = this.get_athletesArray().length;
        Athlet swap;
        boolean sorted=true;
        for(i=0; i<size; i++){

            for(k=i, rightBorder=size-1; k<rightBorder-i; k++){

                 if(k<rightBorder-k && this.get_athletesArray()[k].getResult()< this.get_athletesArray()[rightBorder-k].getResult()){
                    swap= this.get_athletesArray()[k];
                    this.get_athletesArray()[k]= this.get_athletesArray()[rightBorder-k];
                    this.get_athletesArray()[rightBorder-k]=swap;
                    sorted=false;
                 }else if(k>rightBorder-k && this.get_athletesArray()[k].getResult()> this.get_athletesArray()[rightBorder-k].getResult()) {
                     swap = this.get_athletesArray()[k];
                     this.get_athletesArray()[k] = this.get_athletesArray()[rightBorder - k];
                     this.get_athletesArray()[rightBorder - k] = swap;
                     sorted = false;
                 }

                if(this.get_athletesArray()[k].getResult() < this.get_athletesArray()[k+1].getResult()){
                    swap= this.get_athletesArray()[k];
                    this.get_athletesArray()[k]= this.get_athletesArray()[k+1];
                    this.get_athletesArray()[k+1]=swap;
                    sorted=false;
                }

                if(this.get_athletesArray()[rightBorder-k-1].getResult()< this.get_athletesArray()[rightBorder-k].getResult()){
                    swap= this.get_athletesArray()[rightBorder-k-1];
                    this.get_athletesArray()[rightBorder-k-1]= this.get_athletesArray()[rightBorder-k];
                    this.get_athletesArray()[rightBorder-k]=swap;
                    sorted=false;
                }

            }

            if(!sorted){
                sorted=true;
            }else{
                break;
            }
        }
    }

    private void ShowResults(){
        System.out.println("==================");
        System.out.println("Organisators are sorting results!");
        long delta =  System.nanoTime();
        this.SortAthletesResult();
        delta = System.nanoTime()-delta;
        System.out.printf("Organisators have sorted %d results in %d ns! Incredible!\n", this._athletesArray.length ,delta);
        System.out.println("==================");
        int i=1;
        for(Athlet a : this.get_athletesArray()){
            System.out.printf("Athlet %d finished at %d place with result %d\n", a.getId(), i++, a.getResult());
        }
    }

    public void PerformApplication(int _athletesCount, EDisciplines[] _disciplinesOrder){
        PrepareAthletes(_athletesCount); // creating athletes instances
        PrepareDisciplines(_disciplinesOrder); // creating disciplines instances
        PrepareGame(); // creating game instance and setting athletes and disciplines in
        System.out.println("==================");
        System.out.println("Game have began!");
        System.out.println("==================");
        this.get_gamePerformer().PerformGame(); // performing game
        System.out.println("==================");
        System.out.println("Game have ended, showing results....");
        System.out.println("==================");
        ShowResults(); // display results
        System.out.println("==================");
        System.out.println("Have a good day after the game!");
        System.out.println("==================");
    }


    // ==== common funcs end ====
}
