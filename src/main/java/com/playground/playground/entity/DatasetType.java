package com.playground.playground.entity;

/**
 * The {@code DatasetType} enum represents different types of datasets that can be generated. Each
 * dataset type corresponds to a specific pattern or distribution of datasets points.
 */
public enum DatasetType {
  /** Represents a circular dataset where datasets points are distributed in circular clusters. */
  CIRCULAR,

  /** Represents a cluster dataset where datasets points are distributed in clusters. */
  CLUSTER,

  /**
   * Represents a quadrant dataset where datasets points are distributed in the first and third
   * quadrants.
   */
  QUADRANT,

  /** Represents a spiral dataset where datasets points are distributed in a spiral pattern. */
  SPIRAL,

  /** Represents an unknown or unsupported dataset type. */
  UNKNOWN
}
