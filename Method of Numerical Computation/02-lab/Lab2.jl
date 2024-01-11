using PyPlot

function accumulated_error(x::AbstractArray{T}) where T <: Number
    y = similar(x)
    y[1] = x[1]
    for i in 2:length(x)
        y[i] = y[i-1] + x[i]
    end

    return y
end

function plot_error_analysis(size_rand_array::Int = 10^8)
    x = rand(Float32, size_rand_array)
    @time y = accumulated_error(x)
    y_exact = accumulated_error(Float64.(x))
    err = abs.(y .- y_exact) ./ abs.(y_exact) # take absolute value of summed array minus exact array, divide by exact array

    n = 1:10:length(err)
    loglog(n, err[n], color="C1", label="Relative Error")
    ylabel("Relative Error")
    xlabel("# Summands")

    loglog([1, length(err)], sqrt.([1, length(err)]) * 1e-7, "k--", label=L"\sim \sqrt{n}")
    text(1e3, 1e-5, L"\sim \sqrt{n}", transform=gca().transData)
    title("Accumulated error in summing" * "\n" * "$size_rand_array random numbers")

    legend()
    savefig("error_analysis.png")
    println("Saved figure to error_analysis.png")
end

plot_error_analysis()