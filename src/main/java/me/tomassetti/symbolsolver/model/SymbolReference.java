package me.tomassetti.symbolsolver.model;

import java.util.Optional;

/**
 * Created by federico on 28/07/15.
 */
public class SymbolReference<S extends SymbolDeclaration> {

    private Optional<? extends S> correspondingDeclaration;

    public static <S extends SymbolDeclaration, S2 extends S> SymbolReference<S> solved(S2 symbolDeclaration){
        return new SymbolReference(Optional.of(symbolDeclaration));
    }

    public static <S extends SymbolDeclaration, S2 extends S> SymbolReference<S> unsolved(Class<S2> clazz){
        return new SymbolReference(Optional.<S>empty());
    }

    private SymbolReference(Optional<? extends S> correspondingDeclaration){
        this.correspondingDeclaration = correspondingDeclaration;
    }

    public S getCorrespondingDeclaration(){
        if (!isSolved()) {
            throw new IllegalStateException();
        }
        return correspondingDeclaration.get();
    }

    public boolean isSolved() {
        return correspondingDeclaration.isPresent();
    }
}
