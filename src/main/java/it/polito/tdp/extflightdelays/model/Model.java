package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.CoppieAeroporti;
import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private ExtFlightDelaysDAO extFlightDelays;
	
	private Graph<Airport, DefaultWeightedEdge> graph;
	private List<Airport> aeroporti;
	private Map<Integer, Airport> airportId;
	private int numVertici;
	private int numArchi;

	public Model() {
		extFlightDelays = new ExtFlightDelaysDAO();
	}
	
	public void generateGraph(Integer miglia) {
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.aeroporti = extFlightDelays.loadAllAirports();
		this.airportId = new HashMap<>();
		
		for(Airport a : this.aeroporti)
			airportId.put(a.getId(), a);
		
		Graphs.addAllVertices(this.graph, aeroporti);
		
		List<CoppieAeroporti> coppie = extFlightDelays.getCoppieAeroporti(airportId, miglia);
		for(CoppieAeroporti c : coppie) {
			Graphs.addEdge(graph, c.getAeroportoP(), c.getAeroportoA(), c.getAvg());
		}
		
		numVertici = this.graph.vertexSet().size();
		numArchi = this.graph.edgeSet().size();
	}
	
	public Integer getNumVertici() {
		return this.numVertici;
	}
	
	public Integer getNumArchi() {
		return this.numArchi;
	}
	
	public Set<DefaultWeightedEdge> getEdgeSet() {
		return this.graph.edgeSet();
	}

}
