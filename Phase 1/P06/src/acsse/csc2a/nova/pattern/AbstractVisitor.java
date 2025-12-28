package acsse.csc2a.nova.pattern;

import acsse.csc2a.nova.models.Comet;
import acsse.csc2a.nova.models.Moon;
import acsse.csc2a.nova.models.Planet;
import acsse.csc2a.nova.models.Star;

public interface AbstractVisitor {
	void visit(Star star);
    void visit(Planet planet);
    void visit(Moon moon);
    void visit(Comet comet);
}
