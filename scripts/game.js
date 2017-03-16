/*
 * Represents a state in the game
 * @param old [State]: old state to intialize the new state
 */
var State = function(old) {

    /*
     * public : the player who has the turn to player
     */
    this.turn = "";

    /*
     * public : the number of moves of the AI player
     */
    this.oMovesCount = 0;

    /*
     * public : the result of the game in this State
     */
    this.result = "still running";

    /*
     * public : the board configuration in this state
     */
    this.board = [];

    /* Begin Object Construction */
    if(typeof old !== "undefined") {
        // if the state is constructed using a copy of another state
        var len = old.board.length;
        this.board = new Array(len);
        for(var itr = 0 ; itr < len ; itr++) {
            this.board[itr] = old.board[itr];
        }

        this.oMovesCount = old.oMovesCount;
        this.result = old.result;
        this.turn = old.turn;
    }
    /* End Object Construction */

    /*
     * public : advances the turn in a the state
     */
    this.advanceTurn = function() {
        this.turn = this.turn === "X" ? "O" : "X";
    }

    /*
     * public function that enumerates the empty cells in state
     * @return [Array]: indices of all empty cells
     */
    this.emptyCells = function() {
        var indxs = [];
        for(var itr = 0; itr < 16 ; itr++) {
            if(this.board[itr] === "E") {
                indxs.push(itr);
            }
        }
        return indxs;
    }

    /*
     * public  function that checks if the state is a terminal state or not
     * the state result is updated to reflect the result of the game
     * @returns [Boolean]: true if it's terminal, false otherwise
     */

    this.isTerminal = function() {
        var B = this.board;

        //check rows
        for(var i = 0; i <= 12; i = i + 4) {
            if(B[i] !== "E" && B[i] === B[i + 1] && B[i + 1] == B[i + 2] && B[i + 2] == B[i + 3]) {
                this.result = B[i] + "-won"; //update the state result
                return true;
            }
        }

        //check columns
        for(var i = 0; i <= 3 ; i++) {
            if(B[i] !== "E" && B[i] === B[i + 4] && B[i + 4] === B[i + 8] && B[i + 8] === B[i + 12]) {
                this.result = B[i] + "-won"; //update the state result
                return true;
            }
        }

		
        //check diagonals
        
        if(B[0] !== "E" && B[0] == B[5] && B[5] === B[10] && B[10] === B[15]) {
            this.result = B[0] + "-won"; //update the state result
			return true;
        }
			
		if(B[3] !== "E" && B[3] == B[6] && B[6] === B[9] && B[9] === B[12]) {
            this.result = B[3] + "-won"; //update the state result
            return true;
        }
        

        var available = this.emptyCells();
        if(available.length == 0) {
            //the game is draw
            this.result = "draw"; //update the state result
            return true;
        }
        else {
            return false;
        }
    };

};

/*
 * Constructs a game object to be played
 * @param autoPlayer [AIPlayer] : the AI player to be play the game with
 */
var Game = function(autoPlayer) {

    //public : initialize the ai player for this game
    this.ai = autoPlayer;

    // public : initialize the game current state to empty board configuration
    this.currentState = new State();

    //"E" stands for empty board cell
    this.currentState.board = ["E", "E", "E", "E",
                               "E", "E", "E", "E",
							    "E", "E", "E", "E",
                               "E", "E", "E", "E"];

    this.currentState.turn = "X"; //X plays first

    /*
     * initialize game status to beginning
     */
    this.status = "beginning";

    /*
     * public function that advances the game to a new state
     * @param _state [State]: the new state to advance the game to
     */
    this.advanceTo = function(_state) {
        this.currentState = _state;
        if(_state.isTerminal()) {
            this.status = "ended";

            if(_state.result === "X-won")
                //X won
                ui.switchViewTo("won");
            else if(_state.result === "O-won")
                //X lost
                ui.switchViewTo("lost");
            else
                //it's a draw
                ui.switchViewTo("draw");
        }
        else {
            //the game is still running
            if(this.currentState.turn === "X") {
                ui.switchViewTo("human");

            }
            else {
                ui.switchViewTo("robot");

                //notify the AI player its turn has come up
                this.ai.notify("O");
            }
        }
    };

    /*
     * starts the game
     */
    this.start = function() {
        if(this.status = "beginning") {
            //invoke advanceTo with the initial state
            this.advanceTo(this.currentState);
            this.status = "running";
        }
    }

};

/*
 * public static function that calculates the score of the x player in a given terminal state
 * @param _state [State]: the state in which the score is calculated
 * @return [Number]: the score calculated for the human player
 */
Game.score = function(_state) {
    if(_state.result === "X-won"){
        // the x player won
        return 10 - _state.oMovesCount;
    }
    else if(_state.result === "O-won") {
        //the x player lost
        return - 10 + _state.oMovesCount;
    }
    else {
        //it's a draw
        return 0;
    }
}
