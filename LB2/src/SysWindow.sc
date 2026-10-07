;;; Sierra Script 1.0 - (do not remove this comment)
(script# 981)
(include sci.sh)
(use Obj)


(class SysWindow of Obj
	(properties
		sel_20 {SysWindow}
		sel_193 0
		sel_194 0
		sel_195 0
		sel_196 0
		sel_25 0
		sel_26 15
		sel_60 15
		sel_32 0
		sel_31 0
		sel_77 0
		sel_16 0
		sel_17 0
		sel_18 190
		sel_19 320
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_236 0
	)
	
	(method (sel_111)
		(if sel_32 (DisposeWindow sel_32 sel_236) (= sel_32 0))
		(super sel_111:)
	)
	
	(method (sel_189)
		(= sel_32
			(NewWindow
				sel_193
				sel_194
				sel_195
				sel_196
				sel_10
				sel_11
				sel_12
				sel_13
				sel_77
				sel_31
				sel_60
				sel_25
				sel_26
			)
		)
	)
)

(class Window of SysWindow
	(properties
		sel_20 {Window}
		sel_193 0
		sel_194 0
		sel_195 0
		sel_196 0
		sel_25 0
		sel_26 15
		sel_60 -1
		sel_32 0
		sel_31 0
		sel_77 0
		sel_16 0
		sel_17 0
		sel_18 190
		sel_19 320
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_236 0
		sel_5 0
	)
	
	(method (sel_57)
	)
	
	(method (sel_111)
		(self sel_76:)
		(if sel_32 (DisposeWindow sel_32) (= sel_32 0))
		(super sel_111:)
	)
	
	(method (sel_133)
		(return 0)
	)
	
	(method (sel_364 &tmp temp0)
		(= temp0 0)
		(if (!= -1 sel_25) (= temp0 (| temp0 $0001)))
		(if (!= -1 sel_60) (= temp0 (| temp0 $0002)))
		(return temp0)
	)
	
	(method (sel_181 param1 param2)
		(= sel_194 (+ sel_194 param1))
		(= sel_196 (+ sel_196 param2))
		(= sel_196 (+ sel_196 param1))
		(= sel_195 (+ sel_195 param2))
	)
	
	(method (sel_182 param1 param2)
		(self sel_181: (- param1 sel_194) (- param2 sel_193))
	)
	
	(method (sel_80 theSel_25 theSel_60)
		(if (>= argc 1) (= sel_25 theSel_25))
		(if (>= argc 2) (= sel_60 theSel_60))
		(Graph
			grFILL_BOX
			sel_193
			sel_194
			sel_195
			sel_196
			(self sel_364:)
			sel_25
			sel_60
		)
	)
	
	(method (sel_75)
		(= sel_5
			(Graph
				grSAVE_BOX
				sel_193
				sel_194
				sel_195
				sel_196
				(self sel_364:)
			)
		)
	)
	
	(method (sel_76)
		(if sel_5 (Graph grRESTORE_BOX sel_5))
	)
	
	(method (sel_365 param1 param2)
		(= sel_193 (+ sel_193 param2))
		(= sel_194 (+ sel_194 param1))
		(= sel_195 (- sel_195 param2))
		(= sel_196 (- sel_196 param1))
	)
	
	(method (sel_216)
		(Graph
			grUPDATE_BOX
			sel_193
			sel_194
			sel_195
			sel_196
			(self sel_364:)
		)
	)
	
	(method (sel_366)
		(self sel_80: sel_26 -1)
	)
	
	(method (sel_192)
		(self
			sel_182:
				(/ (- (- sel_19 sel_194) (- sel_196 sel_194)) 2)
				(/ (- (- sel_18 sel_193) (- sel_195 sel_193)) 2)
		)
	)
)
