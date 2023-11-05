package jp.skypencil.pjbdd

import org.sosy_lab.pjbdd.api.DD;

// correct https://www.sosy-lab.org/ivy/org.sosy_lab/pjbdd/ivy-v.1.0.10-10.xml
// incorre https://www.sosy-lab.org/ivy/org.sosy_lab/pjbdd/ivy-v1.0.10-10.xml
class Main {
    fun main() {
        //instantiate a new bdd creator with 4 worker
        val creator =
            Builders.bddBuilder()
                .setVarCount(5)
                .setThreads(4)
                .build();

// Create bdd "f1 OR f2" with two integer variables
        val f1 = creator.makeVariable();
        val f2 = creator.makeVariable();
        val orBDD = creator.makeOr(f1, f2);

//Get number of all satisfying true assingments
        val satCount = creator.satCount(orBDD);

// print dot representation of "f1 OR f2"
        println(DotExporter().bddToString(orBDD));
    }
}


