# Gridmind

A simulated national power grid, built as a way to learn distributed systems by running into their problems rather than reading about them.

The system models ~ 10.000 substations across regional control centers, streaming telemetry into an ingest layer that has to store it, serve it, and not lose it. It does **not** model grid physics - the grid is a source of realistic load and a reason for the failure modes. Partitioning, replication, consensus, partial failure and backpressure are the actual subject.

## Status

** Phase 1 ** Single-node monolith, Nothing here is distributed yet, by design - the point is to feel where a single node hurts before splitting it.

## Stack 

Java 21 (virtual threads, structured concurrency), no dependencies yet. 
Go and Rust arrive in later phases, one language per phase.

## Running it

Nothing to run yet.

## Why this is public

I'm learning in the open, including the wrong turns. Design decisions and the mistakes behind them get written up as I go.
