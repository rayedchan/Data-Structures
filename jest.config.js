export default {
  preset: "ts-jest",
  extensionsToTreatAsEsm: [".ts"],
  testEnvironment: "node",
  testEnvironmentOptions: {
    localStorage: null,
  },
  testMatch: ["**/__tests__/**/*.test.ts"],
  moduleFileExtensions: ["ts", "tsx", "js", "jsx", "json", "node"],
  roots: ["<rootDir>/src"],
};
